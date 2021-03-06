/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagepreprocessing.view;

import imagepreprocessing.filter.IParametersPanel;
import imagepreprocessing.filter.ImageFilter;
import imagepreprocessing.filter.ImageFilterChain;
import imagepreprocessing.filter.impl.AdaptiveTresholdBinarizeFilter;
import imagepreprocessing.filter.impl.ClearLowNoise;
import imagepreprocessing.filter.impl.DCTgrayscale;
import imagepreprocessing.filter.impl.DenoiseDCTFilter;
import imagepreprocessing.filter.impl.Dilation;
import imagepreprocessing.filter.impl.EdgeDetection;
import imagepreprocessing.filter.impl.EraseBlackBorderFilter;
import imagepreprocessing.filter.impl.Erosion;
import imagepreprocessing.filter.impl.FillBackground;
import imagepreprocessing.filter.impl.GaborFilter;
import imagepreprocessing.filter.impl.GaussianBluring;
import imagepreprocessing.filter.impl.GaussianNoise;
import imagepreprocessing.filter.impl.GenericConvolutuion;
import imagepreprocessing.filter.impl.GrayscaleFilter;
import imagepreprocessing.filter.impl.HistogramEqualizationFilter;
import imagepreprocessing.filter.impl.HueValues;
import imagepreprocessing.filter.impl.InverseDilatation;
import imagepreprocessing.filter.impl.LetterSegmentationFilter;
import imagepreprocessing.filter.impl.LungCrop;
import imagepreprocessing.filter.impl.LungErosion;
import imagepreprocessing.filter.impl.LungSplit;
import imagepreprocessing.filter.impl.MaskSegmentationFilter;
import imagepreprocessing.filter.impl.MeanFilter;
import imagepreprocessing.filter.impl.MedianFilter;
import imagepreprocessing.filter.impl.MergeImages;
import imagepreprocessing.filter.impl.NormalizationFilter;
import imagepreprocessing.filter.impl.OtsuBinarizeFilter;
import imagepreprocessing.filter.impl.Sample;
import imagepreprocessing.filter.impl.SegmentationOCRFilter;
import imagepreprocessing.filter.impl.SobelEdgeDetection;
import imagepreprocessing.filter.impl.ThinningFilter;
import imagepreprocessing.filter.impl.UnsharpMaskingFilter;
import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.image.CropImageFilter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Panel for creating filter chain
 *
 * @author Sanja
 */
public class ImagePreprocessingPanel extends javax.swing.JPanel {

    //models fo jList
    DefaultListModel allFiltersLM;
    DefaultListModel selectedFiltersLM;
    List<JPanel> parametersPanels;

    /**
     * Creates new form ImagePreprocessingPanel
     */
    public ImagePreprocessingPanel() {
        parametersPanels = new ArrayList<>();
        initComponents();
        setLists();
        hideParameterPanels();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        filtersList = new javax.swing.JList();
        rightButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedFiltersList = new javax.swing.JList();
        leftButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        medianPanel1 = new imagepreprocessing.view.panels.MedianPanel();
        adaptiveTresholdBinarizePanel1 = new imagepreprocessing.view.panels.AdaptiveTresholdBinarizePanel();

        jScrollPane1.setViewportView(filtersList);

        rightButton.setText(">>");
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });

        selectedFiltersList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedFiltersListMouseClicked(evt);
            }
        });
        selectedFiltersList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                selectedFiltersListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(selectedFiltersList);

        leftButton.setText("<<");
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Choose filters");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Filters:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Selected filters:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rightButton)
                            .addComponent(leftButton)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(medianPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(adaptiveTresholdBinarizePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(rightButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leftButton))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(medianPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(adaptiveTresholdBinarizePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Move filter from all filters to selected filters
     *
     * @param evt
     */
    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButtonActionPerformed
        List<ImageFilter> selected = filtersList.getSelectedValuesList();
        for (ImageFilter imageFilter : selected) {
//            allFiltersLM.removeElement(imageFilter);
            selectedFiltersLM.addElement(imageFilter);
        }

    }//GEN-LAST:event_rightButtonActionPerformed
    /**
     * Move filter from selected filters to all filters
     *
     * @param evt
     */
    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButtonActionPerformed
        List<ImageFilter> selected = selectedFiltersList.getSelectedValuesList();
        for (ImageFilter imageFilter : selected) {
//            allFiltersLM.addElement(imageFilter);
            selectedFiltersLM.removeElement(imageFilter);
        }
    }//GEN-LAST:event_leftButtonActionPerformed

    private void selectedFiltersListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedFiltersListMouseClicked

    }//GEN-LAST:event_selectedFiltersListMouseClicked

    private void selectedFiltersListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_selectedFiltersListValueChanged
        ImageFilter selected = (ImageFilter) selectedFiltersList.getSelectedValue();
        hideParameterPanels();
        try {
            if (selected != null) {
                System.out.println("sddsa");
                IParametersPanel ip = (IParametersPanel) selected;
                getPanel(ip.getPanel()).setVisible(true);

            }

        } catch (Exception e) {
        }


    }//GEN-LAST:event_selectedFiltersListValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private imagepreprocessing.view.panels.AdaptiveTresholdBinarizePanel adaptiveTresholdBinarizePanel1;
    private javax.swing.JList filtersList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton leftButton;
    private imagepreprocessing.view.panels.MedianPanel medianPanel1;
    private javax.swing.JButton rightButton;
    private javax.swing.JList selectedFiltersList;
    // End of variables declaration//GEN-END:variables

    /**
     * Set models and add all filters to allFiltersLM
     */
    private void setLists() {

        selectedFiltersLM = new DefaultListModel();
        selectedFiltersList.setModel(selectedFiltersLM);

        allFiltersLM = new DefaultListModel();
        addAllFilters();
        addAllParametersPanels();
        filtersList.setModel(allFiltersLM);

    }

    private void addAllFilters() {
        allFiltersLM.addElement(new AdaptiveTresholdBinarizeFilter());
        allFiltersLM.addElement(new EraseBlackBorderFilter());
        allFiltersLM.addElement(new GrayscaleFilter());
        allFiltersLM.addElement(new HistogramEqualizationFilter());
        allFiltersLM.addElement(new MaskSegmentationFilter());
        allFiltersLM.addElement(new MedianFilter());
        allFiltersLM.addElement(new OtsuBinarizeFilter());
        allFiltersLM.addElement(new EdgeDetection());
        allFiltersLM.addElement(new DCTgrayscale());
        allFiltersLM.addElement(new DenoiseDCTFilter());
        allFiltersLM.addElement(new GaussianBluring());
        allFiltersLM.addElement(new GaussianNoise());
        allFiltersLM.addElement(new MeanFilter());
        allFiltersLM.addElement(new UnsharpMaskingFilter());
        allFiltersLM.addElement(new Dilation());
        allFiltersLM.addElement(new SobelEdgeDetection());
        allFiltersLM.addElement(new Sample());
        allFiltersLM.addElement(new Erosion());
        allFiltersLM.addElement(new LungSplit());
        allFiltersLM.addElement(new FillBackground());
        allFiltersLM.addElement(new MergeImages());
        allFiltersLM.addElement(new LungErosion());
        allFiltersLM.addElement(new LungCrop());
        allFiltersLM.addElement(new InverseDilatation());
        allFiltersLM.addElement(new ClearLowNoise());
        allFiltersLM.addElement(new ThinningFilter());
        allFiltersLM.addElement(new NormalizationFilter());
        allFiltersLM.addElement(new HueValues());
        allFiltersLM.addElement(new SegmentationOCRFilter());
        allFiltersLM.addElement(new GenericConvolutuion());
        allFiltersLM.addElement(new LetterSegmentationFilter());
        allFiltersLM.addElement(new GaborFilter());
//        selectedFiltersLM.addElement(new GrayscaleFilter());
//        selectedFiltersLM.addElement(new GaussianBluring());
//        selectedFiltersLM.addElement(new OtsuBinarizeFilter());
//        selectedFiltersLM.addElement(new EraseBlackBorderFilter());
//        selectedFiltersLM.addElement(new Dilation());
//        selectedFiltersLM.addElement(new Dilation());
//        selectedFiltersLM.addElement(new Erosion());
//        selectedFiltersLM.addElement(new LungSplit());
//        selectedFiltersLM.addElement(new FillBackground());
//        selectedFiltersLM.addElement(new LungErosion());
//        selectedFiltersLM.addElement(new LungErosion());
//        selectedFiltersLM.addElement(new LungErosion());
//        selectedFiltersLM.addElement(new LungErosion());
//        selectedFiltersLM.addElement(new LungErosion());
//        selectedFiltersLM.addElement(new MergeImages());
//        selectedFiltersLM.addElement(new LungCrop());
//        selectedFiltersLM.addElement(new OtsuBinarizeFilter());
//        
                
    }

    private void addAllParametersPanels() {
        parametersPanels.add(medianPanel1);
        parametersPanels.add(adaptiveTresholdBinarizePanel1);

    }

    /**
     * Creates filter chain
     *
     * @return ImageFilterChain
     */
    public ImageFilterChain getImageFilterChain() {
        ImageFilterChain chain = new ImageFilterChain();
        for (Object imageFilter : selectedFiltersLM.toArray()) {
            chain.addFilter((ImageFilter) imageFilter);
        }
        return chain;
    }

    private Component createParametarsPanel(ImageFilter filter) {

        try {
            IParametersPanel pp = (IParametersPanel) filter;
            return pp.getPanel();
        } catch (Exception e) {
            return null;
        }

    }

    private void hideParameterPanels() {
        for (JPanel jPanel : parametersPanels) {
            jPanel.setVisible(false);
        }
    }

    private JPanel getPanel(JPanel panel) {
        for (JPanel jPanel : parametersPanels) {
            if (jPanel.getClass().equals(panel.getClass())) {
                return jPanel;
            }
        }
        return null;
    }

}
