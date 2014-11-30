/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagepreprocessing.filter.impl;

import imagepreprocessing.filter.ImageFilter;
import imagepreprocessing.helper.PreprocessingHelper;
import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Mihailo
 */
public class SegmentationOCRFilter implements ImageFilter {

    private BufferedImage originalImage;
    private BufferedImage filteredImage;

    @Override
    public BufferedImage processImage(BufferedImage image) {

        originalImage = image;

        int width = originalImage.getWidth();
        int height = originalImage.getHeight();

        boolean[][] matrix = new boolean[width][height];

        filteredImage = new BufferedImage(width, height, originalImage.getType());

        int[] histogram = imageHistogram(originalImage);

        int totalNumberOfpixels = height * width;

        int treshold = treshold(histogram, totalNumberOfpixels);

        int black = 0;
        int white = 255;

        int gray;
        int alpha;
        int newColor;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                gray = new Color(originalImage.getRGB(i, j)).getRed();

                if (gray > treshold) {
                    matrix[i][j] = false;
                } else {
                    matrix[i][j] = true;
                }

            }
        }

        
       
        
        int blackTreshold = letterTreshold(originalImage, matrix);
        
        
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
		gray = new Color(originalImage.getRGB(i, j)).getRed();
		alpha = new Color(originalImage.getRGB(i, j)).getAlpha();
				
		if (gray > blackTreshold)
                    newColor = white;
		else
                    newColor = black;
				
		newColor = PreprocessingHelper.colorToRGB(alpha, newColor, newColor, newColor);
		filteredImage.setRGB(i, j, newColor);
            }
	}
        

        return filteredImage;
    }

    public int[] imageHistogram(BufferedImage image) {

        int[] histogram = new int[256];

        for (int i = 0; i < histogram.length; i++) {
            histogram[i] = 0;
        }

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int gray = new Color(image.getRGB(i, j)).getRed();
                histogram[gray]++;
            }
        }
        return histogram;
    }

    public int letterTreshold (BufferedImage original, boolean [][] matrix) {
        double sum = 0;        
        int count = 0;
        
        for (int i = 0; i < original.getWidth(); i++) {
            for (int j = 0; j < original.getHeight(); j++) {
                
                if (matrix[i][j] == true) {
                    int gray = new Color(original.getRGB(i, j)).getRed();
                    sum += gray;
                    count++;    
                }       
            }
        }
        
        if (count == 0)
            return 0;        
        
        return (int)Math.round((sum*3)/(count*2));
    }

    private int treshold(int[] histogram, int total) {
        float sum = 0;
        for (int i = 0; i < 256; i++) {
            sum += i * histogram[i];
        }

        float sumB = 0;
        int wB = 0;
        int wF = 0;

        float varMax = 0;
        int threshold = 0;

        for (int i = 0; i < 256; i++) {
            wB += histogram[i];
            if (wB == 0) {
                continue;
            }
            wF = total - wB;

            if (wF == 0) {
                break;
            }

            sumB += (float) (i * histogram[i]);
            float mB = sumB / wB;
            float mF = (sum - sumB) / wF;

            float varBetween = (float) wB * (float) wF * (mB - mF) * (mB - mF);

            if (varBetween > varMax) {
                varMax = varBetween;
                threshold = i;
            }
        }
        return threshold;
    }
    
    
    public int numberOfBlackPixels (boolean [][] matrix) {
        int count = 0; 
        for (int i = 0; i <originalImage.getWidth(); i++) {
            for (int j = 0; j < originalImage.getHeight(); j++) {
                
                if (matrix[i][j] == false)
                    count++;
                
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Segmentation OCR";
    }
    
    

    
    
}
