package com.xie;

import com.xie.detection.GuiRunUnit;
import com.xie.detection.RunAPI;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.util.Enumeration;

public class DIPinsGUI {
    private JPanel panel1;
    private JTextField textField1;
    private JButton Button1;
    private JTextField textField2;
    private JButton Button2;
    private JTextField textField3;
    private JButton Button3;
    private JTextField textField4;
    private JButton Button4;
    private JTextField textField5;
    private JButton Button5;
    private JButton runButton;
    private JTextArea textArea1;
    private JTextField textField8;

    public DIPinsGUI() {
        //fasta
        Button1.addActionListener(actionEvent -> {
            {
                JFileChooser fc = new JFileChooser("");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setFileFilter(new FileFilter() {// FileFilter 为抽象类
                    // 注意：这个不是实例化FileFilter类 ， 这是采用内部类的方式

                    @Override
                    public String getDescription() {
                        return "Fasta";
                    }

                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory())
                            return true;
                        return f.getName().endsWith("fasta") || f.getName().endsWith("fa");
                    }
                });
                int val = fc.showOpenDialog(null);    //文件打开对话框
                if (val == JFileChooser.APPROVE_OPTION) {
                    //正常选择文件
                    textField1.setText(fc.getSelectedFile().toString());
                } else {
                    //未正常选择文件，如选择取消按钮
                    textField1.setText("未选择文件");
                }
            }
        });
        //fastq1
        Button2.addActionListener(actionEvent -> {
            {
                JFileChooser fc = new JFileChooser("");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public String getDescription() {
                        return "Fastq";
                    }

                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory())
                            return true;
                        return f.getName().endsWith("fastq") || f.getName().endsWith("fq");
                    }
                });

                int val = fc.showOpenDialog(null);    //文件打开对话框
                if (val == JFileChooser.APPROVE_OPTION) {
                    //正常选择文件
                    textField2.setText(fc.getSelectedFile().toString());
                } else {
                    //未正常选择文件，如选择取消按钮
                    textField2.setText("未选择文件");
                }
            }
        });
        //fastq2
        Button3.addActionListener(actionEvent -> {
            {
                JFileChooser fc = new JFileChooser("");
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                fc.setFileFilter(new FileFilter() {
                    @Override
                    public String getDescription() {
                        return "Fastq";
                    }

                    @Override
                    public boolean accept(File f) {
                        if (f.isDirectory())
                            return true;
                        return f.getName().endsWith("fastq") || f.getName().endsWith("fq");
                    }
                });
                int val = fc.showOpenDialog(null);    //文件打开对话框
                if (val == JFileChooser.APPROVE_OPTION) {
                    //正常选择文件
                    textField3.setText(fc.getSelectedFile().toString());
                } else {
                    //未正常选择文件，如选择取消按钮
                    textField3.setText("未选择文件");
                }
            }
        });
        //output directory
        Button4.addActionListener(actionEvent -> {
            {
                JFileChooser fc = new JFileChooser("");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int val = fc.showOpenDialog(null);    //文件打开对话框
                if (val == JFileChooser.APPROVE_OPTION) {
                    //正常选择文件
                    textField4.setText(fc.getSelectedFile().toString());
                } else {
                    //未正常选择文件，如选择取消按钮
                    textField4.setText("未选择文件");
                }
            }
        });
        //cache directory
        Button5.addActionListener(actionEvent -> {
            {
                JFileChooser fc = new JFileChooser("");
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int val = fc.showOpenDialog(null);    //文件打开对话框
                if (val == JFileChooser.APPROVE_OPTION) {
                    //正常选择文件
                    textField5.setText(fc.getSelectedFile().toString());
                } else {
                    //未正常选择文件，如选择取消按钮
                    textField5.setText("未选择文件");
                }
            }
        });
        // run button
        runButton.addActionListener(actionEvent -> {
            GuiRunUnit gunit = new GuiRunUnit();
            gunit.setFastafile(textField1.getText());
            gunit.setFastqfile1(textField2.getText());
            gunit.setFastqfile2(textField3.getText());
            gunit.setOutput(textField4.getText());
            gunit.setCache(textField5.getText());
            gunit.setChr(textField8.getText());
            RunAPI run = new RunAPI();
            String r = gunit.checkValid();
            if (r.equals("true")) {
                textArea1.setText("Run started.\n");
                try {
                    run.run(gunit);
                    textArea1.setText("Run end.\n");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                textArea1.setText(r);
            }
        });
    }

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        EventQueue.invokeLater(() -> {
            try {
                initGlobalFontSetting(new Font("DejaVuSansMono", Font.PLAIN, 16));
                DIPinsGUI window = new DIPinsGUI();
                window.createGUI();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void createGUI() {
        JFrame frame = new JFrame("DIPinsGUI");
        frame.setContentPane(new DIPinsGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void initGlobalFontSetting(Font fnt) {
        FontUIResource fontRes = new FontUIResource(fnt);
        for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements(); ) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource)
                UIManager.put(key, fontRes);
        }
    }
}
