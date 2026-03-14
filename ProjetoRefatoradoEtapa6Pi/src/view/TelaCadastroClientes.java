/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import service.ClienteService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Cliente;

/**
 *
 * @author Juliano
 */
public class TelaCadastroClientes extends javax.swing.JFrame {

    public TelaCadastroClientes() {
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {
        ClienteService service = new ClienteService();
        try {
            String[] colunas = new String[]{"ID", "CPF/CNPJ", "Nome", "Email", "Telefone", "Estado", "Cidade", "CEP", "Bairro", "Numero", "Complemento"};

            List<Cliente> lista = service.listarClientes();

            Object[][] dados = new Object[lista.size()][colunas.length];

            for (int i = 0; i < lista.size(); i++) {
                Cliente c = lista.get(i);

                dados[i][0] = c.getId();
                dados[i][1] = c.getCpfCnpj();
                dados[i][2] = c.getNome();
                dados[i][3] = c.getEmail();
                dados[i][4] = c.getTelefone();
                dados[i][5] = c.getEstado();
                dados[i][6] = c.getCidade();
                dados[i][7] = c.getCep();
                dados[i][8] = c.getBairro();
                dados[i][9] = c.getNumero();
                dados[i][10] = c.getComplemento();
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
                    return super.getColumnClass(columnIndex);
                }
            };
            tabelaClientes.setModel(modelo);

            if (tabelaClientes.getColumnModel().getColumnCount() > 0) {
                tabelaClientes.getColumnModel().getColumn(0).setMinWidth(0);
                tabelaClientes.getColumnModel().getColumn(0).setMaxWidth(0);
                tabelaClientes.getColumnModel().getColumn(0).setWidth(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados do banco: " + e.getMessage());
        }
    }

    public void limparCampos() {
        txtCpfCnpj.setText("");
        txtNome.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        cbEstado.setSelectedIndex(0);
        txtCidade.setText("");
        txtCep.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtComplemento.setText("");
        txtCpfCnpj.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCpfCnpj = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtBairro = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        btnInserir = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Brush Script MT", 0, 36)); // NOI18N
        jLabel1.setText("Transportes Vrum Vrum");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Cadastro de Clientes:");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("CPF/CNPJ:");

        jLabel4.setText("Nome:");

        jLabel5.setText("Email:");

        jLabel6.setText("Telefone:");

        jLabel7.setText("CEP:");

        txtCpfCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfCnpjActionPerformed(evt);
            }
        });

        jLabel9.setText("Número:");

        jLabel10.setText("Complemento:");

        jLabel11.setText("Estado:");

        jLabel12.setText("Bairro:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        jLabel13.setText("Cidade:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o estado:", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", " " }));

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CPF/CNPJ", "Nome", "Email", "Telefone", "Estado", "Cidade", "CEP", "Bairro", "Número", "Complemento"
            }
        ));
        tabelaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaClientes);

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Listagem de Clientes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(28, 28, 28)
                        .addComponent(btnExcluir)
                        .addGap(379, 379, 379))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCpfCnpj, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                            .addComponent(txtNome)
                            .addComponent(txtEmail)
                            .addComponent(txtTelefone)
                            .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCidade)
                            .addComponent(txtCep)
                            .addComponent(txtBairro)
                            .addComponent(txtNumero)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE))
                        .addGap(21, 21, 21))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8))
                .addGap(374, 374, 374))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(410, 410, 410)
                        .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(btnInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCpfCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfCnpjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfCnpjActionPerformed

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        if (txtCpfCnpj.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo CPF/CNPJ.");
            txtCpfCnpj.requestFocus();
        } else if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Nome.");
            txtNome.requestFocus();
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Email.");
            txtEmail.requestFocus();
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Telefone.");
            txtTelefone.requestFocus();
        } else if (cbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, Selecione uma opção de Estado.");
            cbEstado.requestFocus();
        } else if (txtCidade.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Cidade.");
            txtCidade.requestFocus();
        } else if (txtCep.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo CEP.");
            txtCep.requestFocus();
        } else if (txtBairro.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Bairro.");
            txtBairro.requestFocus();
        } else if (txtNumero.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Número.");
            txtNumero.requestFocus();
        } else if (txtComplemento.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo Complemento.");
            txtComplemento.requestFocus();
        } else {
            Cliente c = null;

                //popula os atributos do obj cliente com os valores dos componentes do formulario conforme os parametros do construtor na classe cliente
                c = new Cliente(
                        txtCpfCnpj.getText(),
                        txtNome.getText(),
                        txtEmail.getText(),
                        txtTelefone.getText(),
                        cbEstado.getSelectedItem().toString(),
                        txtCidade.getText(),
                        txtCep.getText(),
                        txtBairro.getText(),
                        Integer.parseInt(txtNumero.getText()),
                        txtComplemento.getText()
                );

            //abre o bloco try pra tentar realizar a insercao do cliente no banco
            try {
                //instancia ClienteService para poder acessar o metodo inserir
                ClienteService service = new ClienteService();

                //passa o obj cliente atraves do metodo inserir
                service.inserirCliente(c);

                //mensagem de sucesso ao inserir o cliente
                JOptionPane.showMessageDialog(null, "Cliente " + c.getNome() + " inserido(a) com sucesso no banco de dados.");

                //limpa os campos
                limparCampos();

                //atualiza a tabela
                atualizarTabela();

            } catch (Exception e) {
                //mensagem de erro caso a insercao nao ocorra
                JOptionPane.showMessageDialog(null, "Erro ao inserir o cliente no banco." + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //pega a linha selecionada
        int linhaSelecionada = tabelaClientes.getSelectedRow();
        //testa se alguma linha foi selecionada
        if (linhaSelecionada == -1) {
            //mensagem de erro caso uma linha nao tenha sido escolhida
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.");
            return;
        }

        //pega o id do registro selecionado
        int idParaExcluir = (int) tabelaClientes.getModel().getValueAt(linhaSelecionada, 0);

        //confirmacao para excluir
        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "tem certeza que deseja excluir o cliente?",
                "confirmar exclusao",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {

            try {
                //instancia a clase ClienteService
                ClienteService service = new ClienteService();

                //chama o metodo que exclui o Cliente
                service.excluirCliente(idParaExcluir);

                //mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso.");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaClientesMouseClicked
        btnInserir.setEnabled(false);
        btnEditar.setEnabled(true);

        int linhaEdicao = tabelaClientes.getSelectedRow();
        if (linhaEdicao != -1) {
            
            txtCpfCnpj.setText(tabelaClientes.getValueAt(linhaEdicao, 1).toString());
            txtNome.setText(tabelaClientes.getValueAt(linhaEdicao, 2).toString());
            txtEmail.setText(tabelaClientes.getValueAt(linhaEdicao, 3).toString());
            txtTelefone.setText(tabelaClientes.getValueAt(linhaEdicao, 4).toString());
            cbEstado.setSelectedIndex(0);
            txtCidade.setText(tabelaClientes.getValueAt(linhaEdicao, 6).toString());
            txtCep.setText(tabelaClientes.getValueAt(linhaEdicao, 7).toString());
            txtBairro.setText(tabelaClientes.getValueAt(linhaEdicao, 8).toString());
            txtNumero.setText(tabelaClientes.getValueAt(linhaEdicao, 9).toString());
            txtComplemento.setText(tabelaClientes.getValueAt(linhaEdicao, 10).toString());
            
            txtCpfCnpj.requestFocus();

    }
    }//GEN-LAST:event_tabelaClientesMouseClicked

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // validando os campos para o usuario não tentar realizar inserções com os campos vazios
        if (txtCpfCnpj.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CPF ou CNPJ do cliente.");
            txtCpfCnpj.requestFocus();
        } else if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Nome do cliente.");
            txtNome.requestFocus();
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Email do cliente.");
            txtEmail.requestFocus();
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Telefone do cliente.");
            txtTelefone.requestFocus();
        } else if (cbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, informe o Estado do cliente.");
            cbEstado.requestFocus();
        } else if (txtCidade.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Cidade do cliente.");
            txtCidade.requestFocus();
        } else if (txtCep.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CEP do cliente.");
            txtCep.requestFocus();
        } else if (txtBairro.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Bairro do cliente.");
            txtBairro.requestFocus();
        } else if (txtNumero.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o número (Residencial) do cliente.");
            txtNumero.requestFocus();
            //aqui um tratamento para garantir que o usuario nao tente entrar com alguma coisa alem de numeros
            int testeNumero;
            try {
                testeNumero = Integer.parseInt(txtNumero.getText());
            } catch (NumberFormatException n) {
             JOptionPane.showMessageDialog(null, "O campo 'Número' deve ser um valor numérico inteiro.");
             txtNumero.requestFocus();
             return;
            }
        } else if (txtComplemento.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe um complemento para o Endereço do Cliente.");
            txtComplemento.requestFocus();
        } else {
            int linhaSelecionada = tabelaClientes.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada para edição.");
                return;
            }
            int idParaEditar = (int) tabelaClientes.getModel().getValueAt(linhaSelecionada, 0);

            Cliente c = new Cliente(
                    txtCpfCnpj.getText(),
                    txtNome.getText(),
                    txtEmail.getText(),
                    txtTelefone.getText(),
                    cbEstado.getSelectedItem().toString(),
                    txtCidade.getText(),
                    txtCep.getText(),
                    txtBairro.getText(),
                    Integer.parseInt(txtNumero.getText()),
                    txtComplemento.getText()
            );
            c.setId(idParaEditar);

            try {
                ClienteService service = new ClienteService();
                service.editarCliente(c);

                JOptionPane.showMessageDialog(null, "Cliente " + c.getNome() + " editado com sucesso!");

                limparCampos();
                atualizarTabela();
                btnInserir.setEnabled(true);
                btnEditar.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar o cliente no banco: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtCpfCnpj;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
