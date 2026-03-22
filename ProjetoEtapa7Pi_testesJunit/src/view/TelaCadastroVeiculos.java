/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import service.VeiculoService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.Veiculo;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Juliano
 */
public class TelaCadastroVeiculos extends javax.swing.JFrame {

    public TelaCadastroVeiculos() {
        initComponents();
        atualizarTabela();
    }

public void atualizarTabela() {

    VeiculoService service = new VeiculoService();

    try {

        String[] colunas = {
            "ID",
            "Modelo",
            "Placa",
            "Ano",
            "Combustível",
            "Capacidade Carga",
            "Renavan",
            "Cor",
            "Seguro"
        };

        List<Veiculo> lista = service.listarVeiculos();

        Object[][] dados = new Object[lista.size()][colunas.length];

        for (int i = 0; i < lista.size(); i++) {

            Veiculo v = lista.get(i);

            dados[i][0] = v.getId();
            dados[i][1] = v.getModelo();
            dados[i][2] = v.getPlaca();
            dados[i][3] = v.getAno();
            dados[i][4] = v.getCombustivel();
            dados[i][5] = v.getCapacidadeCarga();
            dados[i][6] = v.getRenavan();
            dados[i][7] = v.getCor();
            dados[i][8] = v.isSeguro();
        }

        DefaultTableModel modelo = new DefaultTableModel(dados, colunas) {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {

                if (columnIndex == 0) {
                    return Integer.class;
                }

                if (columnIndex == 3) {
                    return Integer.class;
                }

                if (columnIndex == 5) {
                    return Double.class;
                }

                if (columnIndex == 8) {
                    return Boolean.class;
                }

                return super.getColumnClass(columnIndex);
            }
        };

        tabelaVeiculos.setModel(modelo);

        if (tabelaVeiculos.getColumnModel().getColumnCount() > 0) {

            tabelaVeiculos.getColumnModel().getColumn(0).setMinWidth(0);
            tabelaVeiculos.getColumnModel().getColumn(0).setMaxWidth(0);
            tabelaVeiculos.getColumnModel().getColumn(0).setWidth(0);

        }

    } catch (Exception e) {

        JOptionPane.showMessageDialog(this,
                "Erro ao carregar veículos: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtRenavan = new javax.swing.JTextField();
        txtCapacidadeCarga = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtPlaca = new javax.swing.JTextField();
        txtAno = new javax.swing.JTextField();
        rbSim = new javax.swing.JRadioButton();
        rbNao = new javax.swing.JRadioButton();
        txtCor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbCombustivel = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVeiculos = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo:");

        jLabel4.setText("Placa:");

        jLabel5.setText("Ano:");

        jLabel6.setText("Combustível:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        jLabel8.setText("Cor do Veículo:");

        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbSim);
        rbSim.setText("Sim");
        rbSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSimActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNao);
        rbNao.setText("Não");

        jLabel9.setText("Seguro Ativo?");

        jLabel11.setText("Capacidade Carga:");

        jLabel12.setText("Renavan:");

        jLabel1.setFont(new java.awt.Font("Brush Script MT", 0, 36)); // NOI18N
        jLabel1.setText("Transportes Vrum Vrum");

        jLabel2.setText("Cadastro de Veículos");

        cbCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção:", "Gasolina", "Diesel", "Elétrico", "Flex" }));
        cbCombustivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCombustivelActionPerformed(evt);
            }
        });

        tabelaVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Modelo", "Placa", "Ano", "Combustivel", "Capacidade Carga", "Renavan", "Cor", "Seguro"
            }
        ));
        tabelaVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaVeiculos);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Veiculos Cadastrados:");

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtModelo, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtPlaca)
                            .addComponent(txtAno)
                            .addComponent(cbCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbSim)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbNao))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCapacidadeCarga, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                .addComponent(txtRenavan)
                                .addComponent(txtCor)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 318, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnInserir)
                                    .addComponent(jLabel2))))
                        .addGap(306, 306, 306))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(287, 287, 287)
                        .addComponent(btnEditar)
                        .addGap(27, 27, 27)
                        .addComponent(btnExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(358, 358, 358)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCapacidadeCarga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRenavan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbSim)
                            .addComponent(rbNao)
                            .addComponent(jLabel9))))
                .addGap(30, 30, 30)
                .addComponent(btnInserir)
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void limparCampos() {
        txtModelo.setText("");
        txtPlaca.setText("");
        txtAno.setText("");
        cbCombustivel.setSelectedIndex(0);
        txtCapacidadeCarga.setText("");
        txtRenavan.setText("");
        txtCor.setText("");
        txtModelo.setText("");
        buttonGroup1.clearSelection();
        txtModelo.requestFocus();
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (txtModelo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Modelo do veículo.");
        } else if (txtPlaca.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa do veículo.");
        } else if (txtAno.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe o Ano do veículo.");
        } else if (txtCapacidadeCarga.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Capacidade de carga do veículo.");
        } else if (txtRenavan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Renavan do veículo.");
        } else if (txtCor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Cor do veículo.");
        } else if (!rbSim.isSelected() & !rbNao.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe se o veículo possui Seguro.");
        } else if (cbCombustivel.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione o tipo de combustivel.");
        } else {
            //cria uma variavel do tipo Funcionario como null
            Veiculo v = null;
            
            //abre o bloco try pra tratamento de erros

                //popula os atributos do obj veiculo com os valores dos componentes do formulario conforme os parametros do construtor na classe veiculo
                v = new Veiculo(
                        txtModelo.getText(),
                        txtPlaca.getText(),
                        Integer.parseInt(txtAno.getText()),
                        cbCombustivel.getSelectedItem().toString(),
                        Double.parseDouble(txtCapacidadeCarga.getText()),
                        txtRenavan.getText(),
                        txtCor.getText(),
                        rbSim.isSelected()
                );

            //abre o bloco try pra tentar realizar a insercao do veiculo no banco
            try {
                //instancia VeiculoService para poder acessar o metodo inserirVeiculo
                VeiculoService service = new VeiculoService();

                //passa o obj veiculo atraves do metodo inserirVeiculo
                service.inserirVeiculo(v);

                //mensagem de sucesso ao inserir o veiculo
                JOptionPane.showMessageDialog(null, "Veiculo " + v.getModelo()+ " inserido com sucesso no banco de dados.");

                //limpa os campos
                limparCampos();

                //atualiza a tabela
                atualizarTabela();

            } catch (Exception e) {
                //mensagem de erro caso a insercao nao ocorra
                JOptionPane.showMessageDialog(null, "Erro ao inserir o veiculo no banco." + e.getMessage());
            }

        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void rbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbSimActionPerformed

    private void cbCombustivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCombustivelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCombustivelActionPerformed

    private void tabelaVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaVeiculosMouseClicked
        btnInserir.setEnabled(false);
        //pega a linha escolhida da tabela e joga em uma variavel
        int linhaEdicao = tabelaVeiculos.getSelectedRow();
        //testa se uma linha foi selecionada, caso sim, entra no if
        if (linhaEdicao != -1) {
            //pega cada um dos valores do registro selecionado da tabela e joga nos respectivos TextsFields
            txtModelo.setText(tabelaVeiculos.getValueAt(linhaEdicao, 1).toString());
            txtPlaca.setText(tabelaVeiculos.getValueAt(linhaEdicao, 2).toString());
            txtAno.setText(tabelaVeiculos.getValueAt(linhaEdicao, 3).toString());
            cbCombustivel.setSelectedIndex(0);
            txtCapacidadeCarga.setText(tabelaVeiculos.getValueAt(linhaEdicao, 5).toString());
            txtRenavan.setText(tabelaVeiculos.getValueAt(linhaEdicao, 6).toString());
            txtCor.setText(tabelaVeiculos.getValueAt(linhaEdicao, 7).toString());
            buttonGroup1.clearSelection();
            //habilita o botão de edição
            btnEditar.setEnabled(true);
            //manda o cursor direto para o primeiro textfield
            txtModelo.requestFocus();
        }
    }//GEN-LAST:event_tabelaVeiculosMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // validando os campos para o usuario não tentar realizar inserções com os campos vazios
        if (txtModelo.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Modelo do Veículo.");
            txtModelo.requestFocus();
        } else if (txtPlaca.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Placa do Veículo.");
            txtPlaca.requestFocus();
        } else if (txtAno.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Ano do Veículo.");
            txtAno.requestFocus();
        } else if (cbCombustivel.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, escolha a opção de combustível para o Veículo.");
            cbCombustivel.requestFocus();
        } else if (txtCapacidadeCarga.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Capacidade de Carga do Veículo.");
            txtCapacidadeCarga.requestFocus();
        } else if (txtRenavan.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Renavan do Veículo.");
            txtRenavan.requestFocus();
        } else if (txtCor.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Cor do Veículo.");
            txtCor.requestFocus();
        } else if (!rbSim.isSelected() && !rbNao.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe se o Veículo possui Seguro ativo.");
            rbSim.requestFocus();
            //se tudo estiver preenchido, pega a placa do veiculo da linha selecionada na JTable, manda remover da lista
        } else {
            int linhaSelecionada = tabelaVeiculos.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada para edição.");
                return;
            }
            
            int idParaEditar = (int) tabelaVeiculos.getModel().getValueAt(linhaSelecionada, 0);

            Veiculo v = new Veiculo(
                        txtModelo.getText(),
                        txtPlaca.getText(),
                        Integer.parseInt(txtAno.getText()),
                        cbCombustivel.getSelectedItem().toString(),
                        Double.parseDouble(txtCapacidadeCarga.getText()),
                        txtRenavan.getText(),
                        txtCor.getText(),
                        rbSim.isSelected()
                );

            v.setId(idParaEditar);

            try {
                VeiculoService service = new VeiculoService();
                service.editarVeiculo(v);

                JOptionPane.showMessageDialog(null, "Veiculo " + v.getModelo()+ " editado com sucesso!");

                limparCampos();
                atualizarTabela();
                btnInserir.setEnabled(true);
                btnEditar.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar o veiculo no banco: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //pega a linha selecionada
        int linhaSelecionada = tabelaVeiculos.getSelectedRow();
        //testa se alguma linha foi selecionada
        if (linhaSelecionada == -1) {
            //mensagem de erro caso uma linha nao tenha sido escolhida
            JOptionPane.showMessageDialog(null, "Selecione o veiculo para excluir.");
            return;
        }

        //pega o id do registro selecionado
        int idParaExcluir = (int) tabelaVeiculos.getModel().getValueAt(linhaSelecionada, 0);

        //confirmacao para excluir
        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "tem certeza que deseja excluir o veiculo: " + tabelaVeiculos.getValueAt(linhaSelecionada, 1) + "?",
                "confirmar exclusao",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {

            try {
                //instancia a clase VeiculoService
                VeiculoService service = new VeiculoService();

                //chama o metodo que exclui o veiculo
                service.excluirVeiculo(idParaExcluir);

                //mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Veiculo excluido com sucesso.");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroVeiculos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCombustivel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private javax.swing.JTable tabelaVeiculos;
    private javax.swing.JTextField txtAno;
    private javax.swing.JTextField txtCapacidadeCarga;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtRenavan;
    // End of variables declaration//GEN-END:variables
}
