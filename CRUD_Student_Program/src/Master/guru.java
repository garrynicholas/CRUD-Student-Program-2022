/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Simpan = FIX
// Tampil = FIX
// Ubah = FIX
// Hapus = FIX
// Batal = FIX
// Keluar = FIX
// Baru = FIX
// Cari = 

//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
package Master;
//package program_siswa.mainmenu;
//LIBRARY
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.mysql.cj.jdbc.Driver;
import com.mysql.jdbc.*;
//import com.mysql.jdbc.Statement;
import Koneksi.Hubung;
/**
 *
 * @author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
 */
public class guru extends javax.swing.JFrame {
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    /**
     * Creates new form guru
     */
    public guru() {
        initComponents();
        tglskrg();
        this.setSize(640,635);
        tabel1.setModel(tblModel);
        //Tabel(tabel1, new int[]{120,180,120,120});
        txtnip.setEnabled(false);
        txtnama.setEnabled(false);
        cmbmapel.setEnabled(false);
        rdlaki.setEnabled(false);
        rdperempuan.setEnabled(false);
        cmbstatus.setEnabled(false);
        
        cmdsimpan1.setEnabled(false);
        cmdubah1.setEnabled(false);
        cmdhapus1.setEnabled(false);
        cmdkeluar1.setEnabled(true);
        cmdbatal.setEnabled(false);
        cmdbaru.setEnabled(true);
        
        setDefaultTable();
    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    //MENAMPILKAN TANGGAL
    public void tglskrg(){
    Date skrg= new Date();
    SimpleDateFormat format= new SimpleDateFormat("dd MMMM yyyy");
    String tgl = format.format(skrg);
    txttgl.setText(format.format(skrg));
    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    //KONEKSI KE DATABASE
    public void setDefaultTable() {
    String hubung = "jdbc:mysql://localhost:3306/sekolah";
    try {
    Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
    //memanggil variable hubung
    Connection kon = DriverManager.getConnection(hubung,"root","");
    Statement stt = kon.createStatement();
    String SQL = "Select * from guru";
    //res = variable
    ResultSet res = stt.executeQuery(SQL);
    while(res.next()) {
        //digunakan untuk mengisi data tabel
    data[0] = res.getString(1);
    data[1] = res.getString(2);
    data[2] = res.getString(3);
    data[3] = res.getString(4);
    data[4] = res.getString(5);
    tblModel.addRow(data);
    }
    res.close();
    stt.close();
    kon.close();
    } catch(Exception exc) {
    System.err.println(exc.getMessage());
    }
    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    //MEMBUAT PENGATURAN TABEL
    private javax.swing.table.DefaultTableModel tblModel = getDefaultTabelModel();
    private void Tabel(javax.swing.JTable tb, int lebar[]) {
    tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    int kolom=tb.getColumnCount();
    for(int i=0;i < kolom;i++) {
    javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
    //tbc.setPreferredWidth(lebar[i]);
    tb.setRowHeight(17);
    }
    }
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
    return new javax.swing.table.DefaultTableModel(
    new Object [][]{},
    //digunakan untuk menampilkan judul table
    new String []{"NIS","NAMA","MAPEL","JENIS KELAMIN","STATUS"}
    ){
    boolean[] canEdit = new boolean []{
    false, false, false, false
    };
    public boolean isCellEditable(int rowIndex, int columnIndex) {
    return canEdit [columnIndex];
    }
    };
    }
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    int row = 0;
    public void Tampil(){
    row = tabel1.getSelectedRow();
    txtnip.setText(tblModel.getValueAt(row,0).toString());
    txtnama.setText(tblModel.getValueAt(row,1).toString());
    cmbmapel.setSelectedItem(tblModel.getValueAt(row,2).toString());
    if(tblModel.getValueAt(row, 3).toString().equals("Laki-Laki")){
    rdlaki.setSelected(true);
    }else{
    rdperempuan.setSelected(true);
    }
    
//    if(tblModel.getValueAt(row, 3).toString().equals("Aktif")){
//    rdaktif.setSelected(true);
//    }else{
//    rdnonaktif.setSelected(true);
//    }
    cmbstatus.setSelectedItem(tblModel.getValueAt(row,4).toString());
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    txtnip.setEnabled(true);
    txtnama.setEnabled(true);
    cmbmapel.setEnabled(true);
    rdlaki.setEnabled(true);
    rdperempuan.setEnabled(true);
    cmbstatus.setEnabled(true);
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    cmdsimpan1.setEnabled(false);
    cmdubah1.setEnabled(true);
    cmdhapus1.setEnabled(true);
    cmdbatal.setEnabled(true);
    cmdkeluar1.setEnabled(true);
    cmdbaru.setEnabled(false);
    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        cmdsimpan = new javax.swing.JButton();
        cmdubah = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();
        cmdkeluar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        rdperempuan = new javax.swing.JCheckBox();
        cmbmapel = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbstatus = new javax.swing.JComboBox();
        Panel1 = new javax.swing.JPanel();
        cmdsimpan1 = new javax.swing.JButton();
        cmdubah1 = new javax.swing.JButton();
        cmdhapus1 = new javax.swing.JButton();
        cmdkeluar1 = new javax.swing.JButton();
        cmdbatal = new javax.swing.JButton();
        cmdbaru = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnip = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rdlaki = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txttgl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txt_pencarian = new javax.swing.JTextField();
        cmdcari = new javax.swing.JButton();

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray), "Tombol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 11))); // NOI18N

        cmdsimpan.setBackground(new java.awt.Color(51, 255, 0));
        cmdsimpan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmdsimpan.setForeground(new java.awt.Color(255, 255, 255));
        cmdsimpan.setText("Simpan");
        cmdsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpanActionPerformed(evt);
            }
        });

        cmdubah.setBackground(new java.awt.Color(255, 255, 0));
        cmdubah.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmdubah.setText("Ubah");
        cmdubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubahActionPerformed(evt);
            }
        });

        cmdhapus.setBackground(new java.awt.Color(255, 0, 0));
        cmdhapus.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmdhapus.setForeground(new java.awt.Color(255, 255, 255));
        cmdhapus.setText("Hapus");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });

        cmdkeluar.setBackground(new java.awt.Color(255, 0, 0));
        cmdkeluar.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        cmdkeluar.setForeground(new java.awt.Color(255, 255, 255));
        cmdkeluar.setText("Keluar");
        cmdkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmdsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmdubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmdhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmdkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdsimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "NIS", "NAMA", "JENIS KELAMIN", "JURUSAN"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        rdperempuan.setText("Perempuan");
        rdperempuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdperempuanItemStateChanged(evt);
            }
        });
        rdperempuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdperempuanMouseClicked(evt);
            }
        });
        rdperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdperempuanActionPerformed(evt);
            }
        });

        cmbmapel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[Pilihlah]", "Bahasa Indonesia", "Bahasa Jawa", "Bahasa Inggris", "Pemrograman Dasar", "PPKN", "Matematika" }));
        cmbmapel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                cmbmapelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("STATUS GURUN");

        cmbstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "[Pilih Statu]", "PNS", "Guru Kontrak", "GTT" }));
        cmbstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbstatusActionPerformed(evt);
            }
        });

        Panel1.setBackground(new java.awt.Color(255, 255, 255));
        Panel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray), "Tombol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 11))); // NOI18N

        cmdsimpan1.setBackground(new java.awt.Color(255, 0, 204));
        cmdsimpan1.setText("Ssimpan");
        cmdsimpan1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdsimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpan1ActionPerformed(evt);
            }
        });

        cmdubah1.setBackground(new java.awt.Color(255, 0, 255));
        cmdubah1.setText("Ubah");
        cmdubah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubah1ActionPerformed(evt);
            }
        });

        cmdhapus1.setBackground(new java.awt.Color(255, 0, 204));
        cmdhapus1.setText("Hapus");
        cmdhapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapus1ActionPerformed(evt);
            }
        });

        cmdkeluar1.setBackground(new java.awt.Color(255, 0, 204));
        cmdkeluar1.setText("Keluar");
        cmdkeluar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkeluar1ActionPerformed(evt);
            }
        });

        cmdbatal.setBackground(new java.awt.Color(255, 0, 204));
        cmdbatal.setText("Batal");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });

        cmdbaru.setBackground(new java.awt.Color(255, 0, 204));
        cmdbaru.setText("Baru");
        cmdbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbaruActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel1Layout = new javax.swing.GroupLayout(Panel1);
        Panel1.setLayout(Panel1Layout);
        Panel1Layout.setHorizontalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmdsimpan1)
                .addGap(18, 18, 18)
                .addComponent(cmdubah1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdhapus1)
                .addGap(18, 18, 18)
                .addComponent(cmdbatal, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cmdkeluar1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(cmdbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        Panel1Layout.setVerticalGroup(
            Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdubah1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdhapus1))
                    .addComponent(cmdbaru, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdkeluar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmdsimpan1))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA GURU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("NIP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("NAMA");

        txtnama.setText("Isi");
        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("MAPEL");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("JENIS KELAMIN");

        rdlaki.setText("Laki-Lakik");
        rdlaki.setRequestFocusEnabled(false);
        rdlaki.setRolloverEnabled(false);
        rdlaki.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdlakiItemStateChanged(evt);
            }
        });
        rdlaki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdlakiMouseClicked(evt);
            }
        });
        rdlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdlakiActionPerformed(evt);
            }
        });

        tabel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabel1.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tabel1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "NIS", "NAMA", "MAPEL", "JENIS KELAMIN", "STATUS GURU"
            }
        ));
        tabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel1);

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("© XII-RPL 2 - Gunawan Widya Nugraha - Luh Geeky");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Tanggalz:");

        txttgl.setText("22 September 2005");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txttgl)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttgl)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Kari", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 12))); // NOI18N

        cmdcari.setText("Cary");
        cmdcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_pencarian)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 107, Short.MAX_VALUE)
                        .addComponent(cmdcari)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdcari)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdlaki)
                                .addGap(18, 18, 18)
                                .addComponent(rdperempuan))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtnip, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbmapel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cmbstatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(79, 79, 79))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Panel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(32, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbmapel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdlaki)
                            .addComponent(rdperempuan)
                            .addComponent(jLabel5)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(28, 28, 28)
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    //Should be new String[4];
    String data[]=new String[6];
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpanActionPerformed
        // TODO add your handling code here:
        //JENIS KELAMIN
        String jenkel="";
        if(rdlaki.isSelected())
        jenkel="Laki-Laki";
        else
        jenkel="Perempuan";
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        try {
            String hubung = "jdbc:mysql://localhost:3306/sekolah";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "insert into guru values('"+txtnip.getText()+"','"+txtnama.getText()+"','"+cmbmapel.getSelectedItem()+"','"+jenkel+"','"+cmbstatus.getSelectedItem()+"')";
            stt.executeUpdate(SQL);
            data[0]=txtnip.getText();
            data[1]=txtnama.getText();
            data[2]=cmbmapel.getSelectedItem().toString();
            data[3]=jenkel;
            data[4]=cmbstatus.getSelectedItem().toString();
            tblModel.insertRow(0, data);
            txtnip.setText("");
            txtnama.setText("");
            cmbmapel.setSelectedItem("-=List Jurusan=-");
            cmbstatus.setSelectedItem("-=List Jurusan=-");
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmdsimpan.setEnabled(false);
            cmdubah.setEnabled(false);
            cmdhapus.setEnabled(true);
            cmdbatal.setEnabled(false);
            cmdkeluar.setEnabled(true);
            cmdbaru.setEnabled(true);
            stt.close();
            kon.close();
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdsimpanActionPerformed

    private void cmdubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubahActionPerformed
        // TODO add your handling code here:
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    }//GEN-LAST:event_cmdubahActionPerformed

    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        // TODO add your handling code here:
        try {
            String hubung = "jdbc:mysql://localhost:3306/sekolah";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "delete from guru where nis='"+txtnip.getText()+"'";
            stt.executeUpdate(SQL);
            tblModel.removeRow(row);
            txtnip.setText("");
            txtnama.setText("");
            //cmbjurusan.setSelectedItem("-=List Jurusan=-");
            txtnip.setEnabled(false);
            txtnama.setEnabled(false);
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbstatus.setEnabled(false);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmdsimpan1.setEnabled(false);
            cmdubah1.setEnabled(true);
            cmdhapus1.setEnabled(true);
            cmdbatal.setEnabled(true);
            cmdkeluar1.setEnabled(true);
            cmdbaru.setEnabled(false);
            stt.close();
            kon.close();
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdhapusActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
//    public class MainMenu() {
//        public mainmenu() {
//            new mainmenu.setVisible(true);
//        }
//    }
    
    private void cmdkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
//        new MainMenu().setVisible(false);
    }//GEN-LAST:event_cmdkeluarActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdsimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpan1ActionPerformed
        // TODO add your handling code here:
        //JENIS KELAMIN
        String jenkel="";
        if(rdlaki.isSelected())
        jenkel="Laki-Laki";
        else
        jenkel="Perempuan";
        try {
            String hubung = "jdbc:mysql://localhost:3306/sekolah";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "insert into guru values('"+txtnip.getText()+"','"+txtnama.getText()+"','"+cmbmapel.getSelectedItem()+"','"+jenkel+"','"+cmbstatus.getSelectedItem()+"')";
            stt.executeUpdate(SQL);
            data[0]=txtnip.getText();
            data[1]=txtnama.getText();
            data[2]=cmbmapel.getSelectedItem().toString();
            data[3]=jenkel;
            data[4]=cmbstatus.getSelectedItem().toString();
            tblModel.insertRow(0, data);
            txtnip.setText("");
            txtnama.setText("");
            cmbmapel.setSelectedItem("-=MAPEL=-");
            rdlaki.setSelected(false);
            rdperempuan.setSelected(false);
            cmbstatus.setSelectedItem("-=STATUS=-");
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmdsimpan1.setEnabled(false);
            cmdubah1.setEnabled(false);
            cmdhapus1.setEnabled(false);
            cmdbatal.setEnabled(false);
            cmdkeluar1.setEnabled(true);
            cmdbaru.setEnabled(true);
            stt.close();
            kon.close();
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdsimpan1ActionPerformed

    private void cmdubah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubah1ActionPerformed
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        try {
            String hubung = "jdbc:mysql://localhost:3306/sekolah";
            //JENIS KELAMIN
            String jenkel="";
            if(rdlaki.isSelected())
            jenkel="Laki-Laki";
            else
            jenkel="Perempuan";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "update guru set nama_guru='"+txtnama.getText()+"',"+"nama_mapel='"+cmbmapel.getSelectedItem()+"',"+"Jenis_kelamin='"+jenkel+"',"+"status_guru='"+cmbstatus.getSelectedItem()+"' where nip='"+txtnip.getText()+"'";
            stt.executeUpdate(SQL);
            data[0]=txtnip.getText();
            data[1]=txtnama.getText();
            data[2]=cmbmapel.getSelectedItem().toString();
            data[3]=jenkel;
            data[4]=cmbstatus.getSelectedItem().toString();
            tblModel.removeRow(row);
            tblModel.insertRow(row, data);
            txtnip.setText("");
            txtnama.setText("");
            cmbmapel.setSelectedItem("-=Mapel=-");
            rdlaki.setSelected(false);
            rdperempuan.setSelected(false);
            cmbstatus.setSelectedItem("-=Status=-");
            //cmbjurusan.setSelectedItem("-=List Jurusan=-");
            txtnip.setEnabled(false);
            txtnama.setEnabled(false);
            cmbmapel.setEnabled(false);
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbstatus.setEnabled(false);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmdsimpan1.setEnabled(false);
            cmdubah1.setEnabled(false);
            cmdhapus1.setEnabled(false);
            cmdbatal.setEnabled(false);
            cmdkeluar1.setEnabled(true);
            cmdbaru.setEnabled(true);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            stt.close();
            kon.close();
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdubah1ActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdhapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapus1ActionPerformed
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        try {
            String hubung = "jdbc:mysql://localhost:3306/sekolah";
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection kon = DriverManager.getConnection(hubung,"root","");
            Statement stt = kon.createStatement();
            String SQL = "delete from guru where nip='"+txtnip.getText()+"'";
            stt.executeUpdate(SQL);
            tblModel.removeRow(row);
            txtnip.setEnabled(false);
            txtnip.setText("");
            txtnama.setEnabled(false);
            txtnama.setText("");
            cmbmapel.setEnabled(false);
            cmbmapel.setSelectedItem("-=MAPEL=-");
            rdlaki.setEnabled(false);
            rdlaki.setSelected(false);
            rdperempuan.setEnabled(false);
            rdperempuan.setSelected(false);
            cmbstatus.setEnabled(false);
            cmbstatus.setSelectedItem("-=STATUS=-");
            //txtmapel.setText("");
            //cmbjurusan.setSelectedItem("-=List Jurusan=-");
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmdsimpan1.setEnabled(false);
            cmdubah1.setEnabled(false);
            cmdhapus1.setEnabled(false);
            cmdbatal.setEnabled(true);
            cmdkeluar1.setEnabled(true);
            cmdbaru.setEnabled(true);
            stt.close();
            kon.close();
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdhapus1ActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
//    public void MainMenu() {
//        new mainmenu.setVisible(true);
//    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdkeluar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkeluar1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        //new MainMenu().setVisible(false);
    }//GEN-LAST:event_cmdkeluar1ActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // Digunakan untuk menampilkan data yang sudah ada pada table dgn klik 2x mouse
        if(evt.getClickCount()==2){
            Tampil();
        }
    }//GEN-LAST:event_tabelMouseClicked
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void tabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel1MouseClicked
        // Digunakan untuk menampilkan data yang sudah ada pada table dgn klik 2x mouse
        if(evt.getClickCount()==2){
            Tampil();
        }
    }//GEN-LAST:event_tabel1MouseClicked
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        JFrame form = new JFrame();
        form.setSize(400, 400);
        new guru(this);
        setTitle("Data Guru");
    }//GEN-LAST:event_formWindowActivated
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmbstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbstatusActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdlakiActionPerformed
        // TODO add your handling code here:
        if(rdlaki.isSelected()){
        //rdperempuan.enable(false);
        rdperempuan.setEnabled(false);
        } else {
            rdperempuan.setEnabled(true);
        }
    }//GEN-LAST:event_rdlakiActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdperempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdperempuanActionPerformed
        // TODO add your handling code here:
        if(rdperempuan.isSelected()){
        //rdperempuan.enable(false);
        rdlaki.setEnabled(false);
        } else {
            rdlaki.setEnabled(true);
        }
    }//GEN-LAST:event_rdperempuanActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdlakiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdlakiMouseClicked
        // TODO add your handling code here:
        if(rdlaki.isSelected()){
        //rdperempuan.enable(false);
        rdperempuan.setEnabled(false);
        } else {
            rdperempuan.setEnabled(true);
        }
    }//GEN-LAST:event_rdlakiMouseClicked
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdperempuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdperempuanMouseClicked
        // TODO add your handling code here:
        if(rdperempuan.isSelected()){
        //rdperempuan.enable(false);
        rdlaki.setEnabled(false);
        } else {
            rdlaki.setEnabled(true);
        }
    }//GEN-LAST:event_rdperempuanMouseClicked
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdlakiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdlakiItemStateChanged
        // TODO add your handling code here:
        if(rdlaki.isSelected()){
        //rdperempuan.enable(false);
        rdperempuan.setEnabled(false);
        } else {
            rdperempuan.setEnabled(true);
        }
    }//GEN-LAST:event_rdlakiItemStateChanged
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdperempuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdperempuanItemStateChanged
        // TODO add your handling code here:
        if(rdperempuan.isSelected()){
        //rdperempuan.enable(false);
        rdlaki.setEnabled(false);
        } else {
            rdlaki.setEnabled(true);
        }
    }//GEN-LAST:event_rdperempuanItemStateChanged
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmbmapelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_cmbmapelAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbmapelAncestorAdded
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
        // TODO add your handling code here:
        tabel.setEnabled(true);
        txtnip.setEnabled(true);
        txtnip.setText("");
        txtnama.setEnabled(true);
        txtnama.setText("");
        cmbmapel.setEnabled(true);
        cmbmapel.setSelectedItem("Pilih Mapel");
        rdlaki.setEnabled(true);
        rdlaki.setSelected(false);
        rdperempuan.setEnabled(true);
        rdperempuan.setSelected(false);
        cmbstatus.setEnabled(true);
        cmbstatus.setSelectedItem("= Pilih Status");
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        cmdsimpan1.setEnabled(false);
        cmdubah1.setEnabled(false);
        cmdhapus1.setEnabled(false);
        cmdbaru.setEnabled(true);
        cmdbatal.setEnabled(false);
        cmdkeluar1.setEnabled(true);
    }//GEN-LAST:event_cmdbatalActionPerformed

    private void cmdbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbaruActionPerformed
        // TODO add your handling code here:
        tabel.setEnabled(true);
        txttgl.setEnabled(true);
        cmdsimpan1.setEnabled(true);
        cmdubah1.setEnabled(false);
        cmdhapus1.setEnabled(false);
        cmdbaru.setEnabled(false);
        cmdbatal.setEnabled(true);
        cmdkeluar1.setEnabled(true);
        txtnip.requestFocus();
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        txtnip.setEnabled(true);
        txtnip.setText("");
        txtnama.setEnabled(true);
        txtnama.setText("");
        cmbmapel.setEnabled(true);
        cmbmapel.setSelectedItem("= Pilih Mapel =");
        rdlaki.setEnabled(true);
        rdperempuan.setEnabled(true);
        cmbstatus.setEnabled(true);
        cmbstatus.setSelectedItem("= Pilih Status=");
    }//GEN-LAST:event_cmdbaruActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    }//GEN-LAST:event_txtnamaActionPerformed

    private void cmdcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcariActionPerformed
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        try{
            String cari = txt_pencarian.getText();
            Statement stt = (Statement) Hubung.GetConnection().createStatement();
            String sql = "Select * from guru where nip like "+cari+"";
            ResultSet rs = stt.executeQuery(sql);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            if(rs.next()) {
            txtnip.setText(rs.getString(1));
            txtnama.setText(rs.getString(2));
            cmbmapel.setSelectedItem(rs.getString(3));
            
            if(rs.getString(4).equals("Laki-laki")) {
            rdlaki.setSelected(true);
            } else {
                rdperempuan.setSelected(true);
            }
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            cmbstatus.setSelectedItem(rs.getString(5));
            
            txtnip.setEnabled(false);
            txtnama.setEnabled(true);
            cmbmapel.setEnabled(true);
            rdlaki.setEnabled(true);
            rdperempuan.setEnabled(true);
            cmbstatus.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Waduh... tak de lah :(");
            }
            stt.close();
        } catch(Exception e) {
            System.out.println("Terjadi kesalahan....."+e);
        }
        txt_pencarian.setText("");
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        cmdsimpan1.setEnabled(false);
        cmdubah1.setEnabled(true);
        cmdhapus1.setEnabled(true);
        cmdbaru.setEnabled(false);
        cmdbatal.setEnabled(true);
        cmdkeluar1.setEnabled(true);
    }//GEN-LAST:event_cmdcariActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    //MEMBUAT FRAME DI TENGAH
    public guru(JFrame form) {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (dim.width-form.getSize().width)/2;
    int y = (dim.height-form.getSize().height)/2;
    form.setLocation(x,y);
    }
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(guru.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new guru().setVisible(true);
            }
        });
    }
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel Panel1;
    private javax.swing.JComboBox cmbmapel;
    private javax.swing.JComboBox cmbstatus;
    private javax.swing.JButton cmdbaru;
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdcari;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdhapus1;
    private javax.swing.JButton cmdkeluar;
    private javax.swing.JButton cmdkeluar1;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JButton cmdsimpan1;
    private javax.swing.JButton cmdubah;
    private javax.swing.JButton cmdubah1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JCheckBox rdlaki;
    private javax.swing.JCheckBox rdperempuan;
    private javax.swing.JTable tabel;
    private javax.swing.JTable tabel1;
    private javax.swing.JTextField txt_pencarian;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnip;
    private javax.swing.JLabel txttgl;
    // End of variables declaration//GEN-END:variables
}
