package view;
// mÃ n hÃ¬nh intro trÆ°á»›c khi vÃ o pháº§n má»�m
public class IntroView extends javax.swing.JFrame {
	private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel_SoftZyd;
    private javax.swing.JLabel jLabel_inven;
    private javax.swing.JLabel jLabel_inven1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    public javax.swing.JLabel loadingnumber;
    public javax.swing.JProgressBar loadingprogress;
    public IntroView() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel_SoftZyd = new javax.swing.JLabel();
        jLabel_inven = new javax.swing.JLabel();
        loadingprogress = new javax.swing.JProgressBar();
        loadingnumber = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel_inven1 = new javax.swing.JLabel();

       
        jPanel1.setBackground(new java.awt.Color(21, 25, 28));
        jPanel1.setLayout(null);
        jLabel_SoftZyd.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel_SoftZyd.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_SoftZyd.setIcon(new javax.swing.ImageIcon("Images//icons8_DOT_100px.png")); // NOI18N
        jLabel_SoftZyd.setText("SCORES Test");
        jLabel_SoftZyd.setToolTipText("");
        jLabel_SoftZyd.setBounds(200, 120, 400, 140);
        jPanel1.add(jLabel_SoftZyd);
        
        jLabel_inven.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel_inven.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven.setText("nhom3neverdie@gmail.com");
        jLabel_inven.setBounds(10, 0, 200, 30);
        jPanel1.add(jLabel_inven);
        
        loadingprogress.setForeground(new java.awt.Color(169, 224, 49));
        loadingprogress.setBorderPainted(false);
        loadingprogress.setFocusable(false);
        loadingprogress.setRequestFocusEnabled(false);
        loadingprogress.setVerifyInputWhenFocusTarget(false);
        loadingprogress.setBounds(-10, 470, 820, 40);
        jPanel1.add(loadingprogress);
        
        loadingnumber.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        loadingnumber.setForeground(new java.awt.Color(169, 224, 49));
        loadingnumber.setText("99%");
        loadingnumber.setBounds(380, 400, 50, 50);
        jPanel1.add(loadingnumber);
        

        jLabel_inven1.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel_inven1.setForeground(new java.awt.Color(169, 224, 49));
        jLabel_inven1.setText("Management Scores Test");
        jLabel_inven1.setBounds(200, 240, 450, 50);
        jPanel1.add(jLabel_inven1);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setUndecorated(true);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }

}
