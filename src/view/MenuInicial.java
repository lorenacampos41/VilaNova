/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Classes.Conexao;
import Classes.Encomenda;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lorena
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicial
     */
    public void CarregarJtableEventosDia(String sql){
    Connection con;
    try
    {    
     con = Conexao.getConnection();
     PreparedStatement banco = (PreparedStatement)con.prepareStatement(sql);
     banco.execute(); // cria o vetor
     ResultSet resultado = banco.executeQuery(sql);
     DefaultTableModel model =(DefaultTableModel) jTableEventosDia.getModel();
     model.setNumRows(0);
     
     while(resultado.next())
     {   int Cliente_idCliente = resultado.getInt("Cliente_idCliente");       
         String s = "select * from cliente where idCliente ='" +Cliente_idCliente+"'";
         PreparedStatement st = (PreparedStatement)con.prepareStatement(s);
         st.execute();
         ResultSet resultado2 = st.executeQuery(s); 
         if(resultado2.next()){
         model.addRow(new Object[] 
         {   resultado.getInt("idEncomenda"),
             resultado2.getString("nome"),
            resultado.getString("localEntrega"),
            resultado.getTime("horaEntrega")
                                 
         }); 
         }
    } 
     banco.close();
     con.close();
    }
   catch (SQLException ex){
      System.out.println("o erro foi " +ex);
   }
   }
  
    public MenuInicial() {
        initComponents();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");  
        Calendar c = Calendar.getInstance();    
        System.out.println(df.format(c.getTime()));// pega a data atual
        CarregarJtableEventosDia("select * from encomenda where dataEntrega='"+df.format(c.getTime())+"'");
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
        jLabel1 = new javax.swing.JLabel();
        jButtonEncomendas = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButtonClientes = new javax.swing.JButton();
        jButtonRelatórios = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEventosDia = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButtonProdutos = new javax.swing.JButton();
        jButtonOrçamento = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bem Vindo");
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.white);
        jPanel1.setPreferredSize(new java.awt.Dimension(749, 501));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("Vilanova Cervejaria");

        jButtonEncomendas.setFont(new java.awt.Font("DokChampa", 0, 18)); // NOI18N
        jButtonEncomendas.setForeground(new java.awt.Color(51, 0, 0));
        jButtonEncomendas.setText("Encomendas");
        jButtonEncomendas.setFocusPainted(false);
        jButtonEncomendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonEncomendasMouseEntered(evt);
            }
        });
        jButtonEncomendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncomendasActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/logotipo.jpg"))); // NOI18N

        jButtonClientes.setFont(new java.awt.Font("DokChampa", 0, 18)); // NOI18N
        jButtonClientes.setForeground(new java.awt.Color(51, 0, 0));
        jButtonClientes.setText("Clientes");
        jButtonClientes.setFocusPainted(false);
        jButtonClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonClientesMouseEntered(evt);
            }
        });
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonRelatórios.setFont(new java.awt.Font("DokChampa", 0, 18)); // NOI18N
        jButtonRelatórios.setForeground(new java.awt.Color(51, 0, 0));
        jButtonRelatórios.setText("Relatórios");
        jButtonRelatórios.setFocusPainted(false);
        jButtonRelatórios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonRelatóriosMouseEntered(evt);
            }
        });
        jButtonRelatórios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRelatóriosActionPerformed(evt);
            }
        });

        jTableEventosDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTableEventosDia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome do Cliente", "Local de Entrega", "Hora da Entrega", "Finalizar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEventosDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEventosDiaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEventosDia);
        if (jTableEventosDia.getColumnModel().getColumnCount() > 0) {
            jTableEventosDia.getColumnModel().getColumn(0).setPreferredWidth(1);
            jTableEventosDia.getColumnModel().getColumn(2).setPreferredWidth(10);
            jTableEventosDia.getColumnModel().getColumn(3).setResizable(false);
            jTableEventosDia.getColumnModel().getColumn(3).setPreferredWidth(2);
            jTableEventosDia.getColumnModel().getColumn(4).setResizable(false);
            jTableEventosDia.getColumnModel().getColumn(4).setPreferredWidth(1);
        }

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 0, 0));
        jLabel3.setText("Eventos do dia");

        jButtonProdutos.setFont(new java.awt.Font("DokChampa", 0, 18)); // NOI18N
        jButtonProdutos.setForeground(new java.awt.Color(51, 0, 0));
        jButtonProdutos.setText("Produtos");
        jButtonProdutos.setFocusPainted(false);
        jButtonProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonProdutosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonProdutosMouseEntered(evt);
            }
        });

        jButtonOrçamento.setFont(new java.awt.Font("DokChampa", 0, 18)); // NOI18N
        jButtonOrçamento.setForeground(new java.awt.Color(51, 0, 0));
        jButtonOrçamento.setText("Orçamento");
        jButtonOrçamento.setFocusPainted(false);
        jButtonOrçamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButtonOrçamentoMouseEntered(evt);
            }
        });

        jTable2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nome do Cliente", "Local de Entrega", "Finalizar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 0, 0));
        jLabel4.setText("Próximos eventos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonEncomendas)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButtonOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButtonRelatórios, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)
                                        .addComponent(jLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(117, 117, 117))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEncomendas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOrçamento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRelatórios, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOrçamentoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonOrçamentoMouseEntered
        // TODO add your handling code here:
        jButtonOrçamento.setToolTipText("Permite fazer orçamento sem compromisso");
    }//GEN-LAST:event_jButtonOrçamentoMouseEntered

    private void jButtonProdutosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProdutosMouseEntered
        // TODO add your handling code here:
        jButtonProdutos.setToolTipText("Permite cadastrar e exibir produtos");

    }//GEN-LAST:event_jButtonProdutosMouseEntered

    private void jButtonProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonProdutosMouseClicked
        // TODO add your handling code here:
        // abrir tela de produtos
        new MenuProdutos().setVisible(true);
    }//GEN-LAST:event_jButtonProdutosMouseClicked

    private void jButtonRelatóriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRelatóriosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRelatóriosActionPerformed

    private void jButtonRelatóriosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRelatóriosMouseEntered
        jButtonClientes.setToolTipText("Permite: nada por enquanto, hahah");
    }//GEN-LAST:event_jButtonRelatóriosMouseEntered

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        // TODO add your handling code here:
        new MenuCliente().setVisible(true);
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonClientesMouseEntered
        // TODO add your handling code here:
        jButtonClientes.setToolTipText("Permite: Cadastrar, Alterar dados e Excluir clientes");
    }//GEN-LAST:event_jButtonClientesMouseEntered

    private void jButtonEncomendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncomendasActionPerformed
        // abrir a janela de gerenciar cliente
        new MenuEncomendas().setVisible(true);

    }//GEN-LAST:event_jButtonEncomendasActionPerformed

    private void jButtonEncomendasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEncomendasMouseEntered
        // TODO add your handling code here:
        // exibe um hint ao passar o mouse no botão
        jButtonEncomendas.setToolTipText("Permite: Agendar, Alterar dados, Finalizar e Excluir uma encomenda");
    }//GEN-LAST:event_jButtonEncomendasMouseEntered

    private void jTableEventosDiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEventosDiaMouseClicked
        // TODO add your handling code here:
        // ao marcar a opcao finalizar alterar a situacao para enviado!
        // pegar a linha que foi selecionada
         int coluna_selecionada = jTableEventosDia.getSelectedColumn();
         if (coluna_selecionada == 4){ // se o botao da coluna 5 estiver ativado
               // pegar o codigo da linha selecionda
                int linha=jTableEventosDia.getSelectedRow();
                int cod=(int)jTableEventosDia.getValueAt(linha,0);// pega valor da linha e coluna 0 (codigo)
                // remover do banco
                Encomenda en=new Encomenda();
                en.AlterarSituacao(cod);
                // remover o item da jTable
                DefaultTableModel modelo = (DefaultTableModel)jTableEventosDia.getModel();
                modelo.removeRow(jTableEventosDia.getSelectedRow());   
                // pegar o codigo da encomenda 
          }     
    }//GEN-LAST:event_jTableEventosDiaMouseClicked

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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonEncomendas;
    private javax.swing.JButton jButtonOrçamento;
    private javax.swing.JButton jButtonProdutos;
    private javax.swing.JButton jButtonRelatórios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableEventosDia;
    // End of variables declaration//GEN-END:variables
}
