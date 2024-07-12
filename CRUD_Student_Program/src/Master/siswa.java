/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// BARU = FIX
// SIMPAN = FIX
// KELUAR = FIX
// HAPUS = FIX 
// UBAH = FIX
// BATAL = FIX
// CARI = FIX
/**
 *
 * @author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
 */

package Master;
//LIBRARY
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.jdbc.Driver;
import com.mysql.jdbc.*;
import Koneksi.Hubung;


//Membuat class
public class siswa extends javax.swing.JFrame { //Kurawal awal program
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    /**
     * Creates new form siswa
     */
    public siswa() {
        initComponents();
        tglskrg();
        this.setSize(690,730);
        this.setLocationRelativeTo(null);
        tabel.setModel(tblModel);
        Tabel(tabel, new int[]{240,240,550,240});
        tabel.getColumnModel().getColumn(0).setPreferredWidth(40);
        tabel.getColumnModel().getColumn(1).setPreferredWidth(120);
        tabel.getColumnModel().getColumn(2).setPreferredWidth(70);
        tabel.getColumnModel().getColumn(3).setPreferredWidth(70);
        tabel.getColumnModel().getColumn(4).setPreferredWidth(110);
        tabel.getColumnModel().getColumn(5).setPreferredWidth(120);
        tabel.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        setDefaultTable();
        tabel.setEnabled(true);
        txtnis.setEnabled(false);
        txtnama.setEnabled(false);
        t_lahir.setEnabled(false);
        rdlaki.setEnabled(false);
        rdperempuan.setEnabled(false);
        cmbjurusan.setEnabled(false);
        txt_alamat.setEnabled(false);
        
        cmdsimpan.setEnabled(false);
        cmdubah.setEnabled(false);
        cmdbatal.setEnabled(false);
        cmdhapus.setEnabled(false);
        cmdkeluar.setEnabled(true);
        txttgl.setEnabled(false);
    }
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
    try {
    Statement stt = (Statement) Hubung.GetConnection().createStatement();
    String SQL = "Select * from siswa";
    //res = variable
    ResultSet res = stt.executeQuery(SQL);
    while(res.next()) {
        //digunakan untuk mengisi data tabel
    data[0] = res.getString(1);
    data[1] = res.getString(2);
    data[2] = res.getString(3);
    data[3] = res.getString(4);
    data[4] = res.getString(5);
    data[5] = res.getString(6);
    tblModel.addRow(data);
    }
    res.close();
    stt.close();
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
    new String []{"NIS","NAMA","TANGGAL LAHIR","JENIS KELAMIN","KONSENTRASI KEAHLIAN","ALAMAT"}
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
    row = tabel.getSelectedRow();
    txtnis.setEnabled(true);
    txtnama.setEnabled(true);
    t_lahir.setEnabled(true);
    rdlaki.setEnabled(true);
    rdperempuan.setEnabled(true);
    cmbjurusan.setEnabled(true);
    txt_alamat.setEnabled(true);
    txttgl.setEnabled(true);
    
    txtnis.setText(tblModel.getValueAt(row,0).toString());
    txtnama.setText(tblModel.getValueAt(row,1).toString());
    t_lahir.setSelectedItem(tblModel.getValueAt(row,2).toString());
    if(tblModel.getValueAt(row, 3).toString().equals("Laki-Laki")){
    rdlaki.setSelected(true);
    rdperempuan.setSelected(false);
    }else{
    rdperempuan.setSelected(true);
    rdlaki.setSelected(false);
    }
    cmbjurusan.setSelectedItem(tblModel.getValueAt(row,4).toString());
    txt_alamat.setText(tblModel.getValueAt(row,5).toString());
    
    cmdubah.setEnabled(true);
    cmdhapus.setEnabled(true);
    cmdbaru.setEnabled(false);
    cmdbatal.setEnabled(true);
    cmdkeluar.setEnabled(true);
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    try {
        Date tanggal = dateFormat.parse((String) tblModel.getValueAt(row,2).toString());
        //t_lahir.setDate(tanggal);
    } catch (java.text.ParseException ex) {
        System.out.println("Tanggal tidak sesuai format");
    }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        Panel = new javax.swing.JPanel();
        cmdsimpan = new javax.swing.JButton();
        cmdubah = new javax.swing.JButton();
        cmdhapus = new javax.swing.JButton();
        cmdkeluar = new javax.swing.JButton();
        cmdbaru = new javax.swing.JButton();
        cmdbatal = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cmdcari = new javax.swing.JButton();
        txt_pencarian = new javax.swing.JTextField();
        txttgl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtnis = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        t_lahir = new javax.swing.JComboBox<String>();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rdlaki = new javax.swing.JRadioButton();
        rdperempuan = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        cmbjurusan = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATA SISWA");

        tabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        tabel.setFont(new java.awt.Font("Roboto", 0, 11)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NIP", "NAMA", "TANGGAL LAHIR", "JENIS KELAMIN", "KONSENTRASI KEAHLIAN", "ALAMAT"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.gray), "Tombol", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 11))); // NOI18N

        cmdsimpan.setBackground(new java.awt.Color(0, 102, 102));
        cmdsimpan.setText("Simpan.");
        cmdsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        cmdsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsimpanActionPerformed(evt);
            }
        });

        cmdubah.setText("Ubah");
        cmdubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdubahActionPerformed(evt);
            }
        });

        cmdhapus.setBackground(new java.awt.Color(102, 102, 0));
        cmdhapus.setText("Hapus");
        cmdhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdhapusActionPerformed(evt);
            }
        });

        cmdkeluar.setForeground(new java.awt.Color(102, 0, 102));
        cmdkeluar.setText("Keluar");
        cmdkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkeluarActionPerformed(evt);
            }
        });

        cmdbaru.setBackground(new java.awt.Color(0, 102, 51));
        cmdbaru.setText("Baru");
        cmdbaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbaruActionPerformed(evt);
            }
        });

        cmdbatal.setText("Batal");
        cmdbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbatalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(cmdsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdubah, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(cmdhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdbatal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmdbaru, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdbaru, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdkeluar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdsimpan)
                        .addComponent(cmdubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmdbatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdhapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Roboto", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("© XII-RPL 2 - Gunawan Widya Nugraha");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Kari", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri", 1, 14))); // NOI18N

        cmdcari.setText("Carik");
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
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(cmdcari, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txt_pencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdcari)
                .addGap(6, 6, 6))
        );

        txttgl.setText("22 September 2005");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Tanggalz:");

        txtnis.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("NIS");

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("NAMA");

        txtnama.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        t_lahir.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Choose Date", "2005-09-22", "2006-09-14", "2005-09-30", "2005-09-18", "2006-09-07", "2005-09-25", "2005-09-10", "2004-09-21", "2005-09-05", "2007-09-12", "2005-09-28" }));

        jLabel9.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel9.setText("TANGGAL LAHIR");

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("JENIS KELAMIN");

        rdlaki.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rdlaki.setText("LAKI-LAKI");
        rdlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdlakiActionPerformed(evt);
            }
        });

        rdperempuan.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        rdperempuan.setText("PEREMPUAN");
        rdperempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdperempuanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("KONS.KEAHLIAN");

        cmbjurusan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "= Pilih Konsentrasi Keahlian =", "Rekayasa Perangkat Lunak", "Teknik Komputer Jaringan", "Multimedia", "Bisnis Dan Pemasaran", "Kamu nanya :>" }));
        cmbjurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbjurusanActionPerformed(evt);
            }
        });

        txt_alamat.setColumns(20);
        txt_alamat.setRows(5);
        jScrollPane2.setViewportView(txt_alamat);

        jLabel8.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel8.setText("ALAMAK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(rdlaki)
                                            .addGap(18, 18, 18)
                                            .addComponent(rdperempuan)
                                            .addGap(0, 39, Short.MAX_VALUE))
                                        .addComponent(cmbjurusan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(120, 120, 120)
                                    .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel9))
                                    .addGap(32, 32, 32)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(t_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtnama))))
                            .addComponent(jLabel8))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttgl)
                                .addGap(110, 110, 110))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(Panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(348, 348, 348))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txttgl)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdlaki)
                            .addComponent(rdperempuan)
                            .addComponent(jLabel4)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbjurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    String data[]=new String[6];
    //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened
    
    //Klik kanan Frame – Events – Window - windowActivated
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        JFrame form = new JFrame();
        form.setSize(400, 400);
        new siswa(this);
        setTitle("FORMULIR DATA SISWA");
    }//GEN-LAST:event_formWindowActivated

    private void cmdkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_cmdkeluarActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdhapusActionPerformed
        // TODO add your handling code here:
        try {
            txtnis.setEnabled(false);
            txtnama.setEnabled(false);
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbjurusan.setEnabled(false);

            Statement stt = (Statement) Hubung.GetConnection().createStatement();
            String SQL = "delete from siswa where nis='"+txtnis.getText()+"'";
            stt.executeUpdate(SQL);
            tblModel.removeRow(row);

            txtnis.setText("");
            txtnama.setText("");
            t_lahir.setEnabled(false);
            t_lahir.setSelectedItem("");
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbjurusan.setSelectedItem("-=List Jurusan=-");
            
            stt.close();

            cmdsimpan.setEnabled(false);
            cmdubah.setEnabled(false);
            cmdhapus.setEnabled(false);
            cmdbaru.setEnabled(true);
            
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdhapusActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdubahActionPerformed
        // TODO add your handling code here:
        try {
            String jenkel="";
            if(rdlaki.isSelected())
            jenkel="Laki-Laki";
            else
            jenkel="Perempuan";
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            txtnis.setEnabled(false);
            txtnama.setEnabled(false);
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbjurusan.setEnabled(false);
            
            Statement stt = (Statement) Hubung.GetConnection().createStatement();
            String SQL = "update siswa set nama='"+txtnama.getText()+"', tanggal_lahir='"+t_lahir.getSelectedItem()+"', jenkel='"+jenkel+"', cmbjurusan='"+cmbjurusan.getSelectedItem()+"', alamat='"+txt_alamat.getText()+"' where nis='"+txtnis.getText()+"'";
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            stt.executeUpdate(SQL);
            data[0]=txtnis.getText();
            data[1]=txtnama.getText();
            data[2]=t_lahir.getSelectedItem().toString();
            data[3]=jenkel;
            data[4]=cmbjurusan.getSelectedItem().toString();
            data[5]=txt_alamat.getText();
            
            tblModel.removeRow(row);
            tblModel.insertRow(row, data);
            
            txtnis.setText("");
            txtnama.setText("");
            t_lahir.setSelectedItem("Choose Date");
            rdlaki.setSelected(false);
            rdperempuan.setSelected(false);
            cmbjurusan.setSelectedItem("-=List Jurusan=-");
            txt_alamat.setText("");
            stt.close();
            
            cmdbaru.setEnabled(true);
            cmdbatal.setEnabled(false);
            cmdubah.setEnabled(false);
            cmdsimpan.setEnabled(false);
            cmdhapus.setEnabled(false);
   
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdubahActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsimpanActionPerformed
        // TODO add your handling code here:
        String jenkel="";
        if(rdlaki.isSelected())
        jenkel="Laki-Laki";
        else
        jenkel="Perempuan";
        try {
            txtnis.setEnabled(false);
            txtnama.setEnabled(false);
            t_lahir.setEnabled(false);
            rdlaki.setEnabled(false);
            rdperempuan.setEnabled(false);
            cmbjurusan.setEnabled(false);
            txt_alamat.setEnabled(false);
            
            Statement stt = (Statement) Hubung.GetConnection().createStatement();
            String SQL = "insert into siswa values('"+txtnis.getText()+"','"+txtnama.getText()+"','"+t_lahir.getSelectedItem()+"','"+jenkel+"','"+cmbjurusan.getSelectedItem()+"','"+txt_alamat.getText()+"')";
            stt.executeUpdate(SQL);
            data[0]=txtnis.getText();
            data[1]=txtnama.getText();
            data[2]=t_lahir.getSelectedItem().toString();
            data[3]=jenkel;
            data[4]=cmbjurusan.getSelectedItem().toString();
            data[5]=txt_alamat.getText();
            tblModel.insertRow(0, data);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            txtnis.setText("");
            txtnama.setText("");
            rdlaki.setSelected(false);
            rdperempuan.setSelected(false);
            cmbjurusan.setSelectedItem("-=Pilih Konsentrasi Keahlian=-");
            txt_alamat.setText("");
            
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            stt.close();
            
            cmdbaru.setEnabled(true);
            cmdbatal.setEnabled(false);
            cmdubah.setEnabled(false);
            
            cmdhapus.setEnabled(false);
            cmdsimpan.setEnabled(false);
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        } catch(Exception exc) {
            System.err.println(exc.getMessage());
        }
    }//GEN-LAST:event_cmdsimpanActionPerformed

    //MEMBUAT TABEL DIKLIK 2X DENGAN MOUSE
    //Klik kanan tabel – Events – Mouse - mouseClicked
    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // Digunakan untuk menampilkan data yang sudah ada pada table dgn klik 2x mouse
        if(evt.getClickCount()==2){
            Tampil();
        }
    }//GEN-LAST:event_tabelMouseClicked
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmbjurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbjurusanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbjurusanActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void rdlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdlakiActionPerformed
        if(rdlaki.isSelected()){
        //rdperempuan.enable(false);
        rdperempuan.setEnabled(false);
        } else {
            rdperempuan.setEnabled(true);
        }
    }//GEN-LAST:event_rdlakiActionPerformed
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    private void cmdcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdcariActionPerformed
        // TODO add your handling code here:
        try{
            String cari = txt_pencarian.getText();
            Statement stt = (Statement) Hubung.GetConnection().createStatement();
            String sql = "Select * from siswa where nis like "+cari+"";
            ResultSet rs = stt.executeQuery(sql);
            
            if(rs.next()) {
            txtnis.setText(rs.getString(1));
            txtnama.setText(rs.getString(2));
            t_lahir.setSelectedItem(rs.getString(3));
            
            if(rs.getString(4).equals("Laki-laki")) {
            rdlaki.setSelected(true);
            } else {
                rdperempuan.setSelected(true);
            }
            
            cmbjurusan.setSelectedItem(rs.getString(5));
            txt_alamat.setText(rs.getString(5));
            //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
            txtnis.setEnabled(false);
            txtnama.setEnabled(true);
            t_lahir.setEnabled(true);
            rdlaki.setEnabled(true);
            rdperempuan.setEnabled(true);
            cmbjurusan.setEnabled(true);
            txt_alamat.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "Sorry :( We cannot find any data here");
            }
            stt.close();
        } catch(Exception e) {
            System.out.println("Terjadi kesalahan....."+e);
        }
        txt_pencarian.setText("");
        cmdbaru.setEnabled(false);
        cmdsimpan.setEnabled(false);
        cmdbatal.setEnabled(true);
        cmdubah.setEnabled(true);
        cmdhapus.setEnabled(true);
        cmdkeluar.setEnabled(true);
        
    }//GEN-LAST:event_cmdcariActionPerformed

    private void cmdbaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbaruActionPerformed
        // TODO add your handling code here:
        tabel.setEnabled(true);
        txttgl.setEnabled(true);
        cmdsimpan.setEnabled(true);
        cmdubah.setEnabled(false);
        cmdhapus.setEnabled(false);
        cmdbaru.setEnabled(false);
        cmdbatal.setEnabled(true);
        cmdkeluar.setEnabled(true);
        txtnis.requestFocus();
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        txtnama.setEnabled(true);
        txtnama.setText("");
        txtnis.setEnabled(true);
        txtnis.setText("");
        t_lahir.setEnabled(true);
        t_lahir.setSelectedItem("");
        rdlaki.setEnabled(true);
        rdperempuan.setEnabled(true);
        cmbjurusan.setEnabled(true);
        cmbjurusan.setSelectedItem("= Pilih Konsentrasi Keahlian =");
        txt_alamat.setEnabled(true);
        
    }//GEN-LAST:event_cmdbaruActionPerformed

    private void cmdbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbatalActionPerformed
        // TODO add your handling code here:
        tabel.setEnabled(true);
        txtnis.setEnabled(true);
        txtnis.setText("");
        txtnama.setEnabled(true);
        txtnama.setText("");
        t_lahir.setEnabled(true);
        t_lahir.setSelectedItem("");
        rdlaki.setEnabled(true);
        rdperempuan.setEnabled(true);
        cmbjurusan.setEnabled(true);
        cmbjurusan.setSelectedItem("= Pilih Konsentrasi Keahlian");
        txt_alamat.setEnabled(true);
        txt_alamat.setText("");
        //@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
        cmdsimpan.setEnabled(false);
        cmdubah.setEnabled(false);
        cmdhapus.setEnabled(false);
        cmdbaru.setEnabled(true);
        cmdbatal.setEnabled(false);
        cmdkeluar.setEnabled(true);
        
    }//GEN-LAST:event_cmdbatalActionPerformed

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
    //MEMBUAT FRAME DI TENGAH
    public siswa(JFrame form) {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (dim.width-form.getSize().width)/2;
    int y = (dim.height-form.getSize().height)/2;
    form.setLocation(x,y);
    }
    
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
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new siswa().setVisible(true);
            }
        });
    }
//@author GUNAWAN WIDYA NUGRAHA - 10 - 12 RPL 2
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    private javax.swing.JComboBox cmbjurusan;
    private javax.swing.JButton cmdbaru;
    private javax.swing.JButton cmdbatal;
    private javax.swing.JButton cmdcari;
    private javax.swing.JButton cmdhapus;
    private javax.swing.JButton cmdkeluar;
    private javax.swing.JButton cmdsimpan;
    private javax.swing.JButton cmdubah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdlaki;
    private javax.swing.JRadioButton rdperempuan;
    private javax.swing.JComboBox<String> t_lahir;
    private javax.swing.JTable tabel;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_pencarian;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnis;
    private javax.swing.JLabel txttgl;
    // End of variables declaration//GEN-END:variables
}
