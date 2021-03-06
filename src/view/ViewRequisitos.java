/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import model.bean.Complexidade;
import model.dao.ComplexidadeDAO;
import model.bean.Prioridade;
import model.dao.PrioridadeDAO;
import model.bean.Projeto;
import model.dao.ProjetoDAO;
import model.bean.Requisito;
import model.dao.RequisitoDAO;

/**
 *
 * @author Gabriel
 */
public class ViewRequisitos extends javax.swing.JFrame {
    private Projeto projeto;
    /**
     * Creates new form ViewRequisitos
     */
    public ViewRequisitos(Projeto currentProjeto) {
        this.projeto = currentProjeto;
        initComponents();
        lblNomeHolder.setText(this.projeto.getNome());
        lblDescHolder.setText(this.projeto.getDescricao());
        this.populateComplexComboBox();
        this.populatePriorityComboBox();
        this.readJTable();
    }
    
    public ViewRequisitos() {
        initComponents();
        this.populateComplexComboBox();
        this.populatePriorityComboBox();
        this.readJTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        cmbPrioridade = new javax.swing.JComboBox<>();
        cmbComplexidade = new javax.swing.JComboBox<>();
        lblDescricao1 = new javax.swing.JLabel();
        lblComplexidade = new javax.swing.JLabel();
        txtEsforco = new javax.swing.JTextField();
        lblEsforco = new javax.swing.JLabel();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtDescricao = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTRequisitos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        lblDescFix = new javax.swing.JLabel();
        lblNomeHolder = new javax.swing.JLabel();
        lblNomeFix = new javax.swing.JLabel();
        lblDescHolder = new javax.swing.JLabel();

        jPanel1.setToolTipText("");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblNome.setText("Nome");

        lblDescricao.setText("Descri????o");

        cmbPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbComplexidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblDescricao1.setText("Prioridade");

        lblComplexidade.setText("Complexidade");

        txtEsforco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEsforcoActionPerformed(evt);
            }
        });

        lblEsforco.setText("Esfor??o (em Horas)");

        btnNovo.setText("Novo");

        btnSalvar.setText("Salvar");

        btnExcluir.setText("Excluir");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbComplexidade, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtEsforco)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(lblNome)
                            .addComponent(lblDescricao)
                            .addComponent(cmbPrioridade, 0, 219, Short.MAX_VALUE)
                            .addComponent(lblDescricao1)
                            .addComponent(lblComplexidade)
                            .addComponent(lblEsforco)
                            .addComponent(txtDescricao))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addComponent(btnExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNovo, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDescricao1)
                .addGap(10, 10, 10)
                .addComponent(cmbPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblComplexidade)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbComplexidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblEsforco)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEsforco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar))
                .addGap(18, 18, 18)
                .addComponent(btnExcluir)
                .addContainerGap())
        );

        jTRequisitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "Descri????o", "Data de Cria????o", "Autor", "Usuario da ultima modifica????o", "Data da ultima modifica????o", "Id prioridade", "Esfor??o em Horas", "Complexidade", "Projeto"
            }
        ));
        jScrollPane2.setViewportView(jTRequisitos);

        jButton1.setText("Atualizar");

        lblDescFix.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblDescFix.setText("Descri????o: ");

        lblNomeHolder.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNomeHolder.setText("-");

        lblNomeFix.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblNomeFix.setText("Nome: ");

        lblDescHolder.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblDescHolder.setText("-");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 1044, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescFix)
                            .addComponent(lblNomeFix))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNomeHolder)
                            .addComponent(lblDescHolder))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblDescFix))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNomeHolder)
                            .addComponent(lblNomeFix))
                        .addGap(1, 1, 1)
                        .addComponent(lblDescHolder)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEsforcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEsforcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEsforcoActionPerformed
    
    private void populateComplexComboBox(){
        ComplexidadeDAO dao = new ComplexidadeDAO();
        List<Complexidade> listTocmb = dao.read();
        
        cmbComplexidade.removeAll();

        cmbComplexidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        
        for(Complexidade c: listTocmb){
            cmbComplexidade.addItem(c.getNome());
        }
    }
    
    private void populatePriorityComboBox(){
        PrioridadeDAO dao = new PrioridadeDAO();
        List<Prioridade> listTocmb = dao.read();
        
        cmbPrioridade.removeAll();
        
        cmbPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
 
        for(Prioridade p: listTocmb){
            cmbPrioridade.addItem(p.getNome());
        }
    }
    
    public void readJTable() {
        
        DefaultTableModel modelo = (DefaultTableModel) jTRequisitos.getModel();
        modelo.setNumRows(0);
        RequisitoDAO pdao = new RequisitoDAO();

        for (Requisito p : pdao.getListByProjeto(this.projeto.getId())) {

            modelo.addRow(new Object[]{
                p.getIdRequisito(),
                p.getNome(),
                p.getDescricao(),
                p.getDatacriacao(),
                p.getAutor(),
                p.getUsuario_ultimamodificacao(),
                p.getData_ultimamodificacao(),
                p.getId_prioridade(),
                p.getEsforco_horas(),
                p.getComplexidade(),
                p.getId_projeto()
            });

        }

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
            java.util.logging.Logger.getLogger(ViewRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewRequisitos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewRequisitos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbComplexidade;
    private javax.swing.JComboBox<String> cmbPrioridade;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTRequisitos;
    private javax.swing.JLabel lblComplexidade;
    private javax.swing.JLabel lblDescFix;
    private javax.swing.JLabel lblDescHolder;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblDescricao1;
    private javax.swing.JLabel lblEsforco;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNomeFix;
    private javax.swing.JLabel lblNomeHolder;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtEsforco;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
