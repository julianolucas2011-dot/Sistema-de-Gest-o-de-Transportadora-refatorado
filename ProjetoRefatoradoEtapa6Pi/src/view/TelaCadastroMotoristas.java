package view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Motorista;
import service.MotoristaService;

public class TelaCadastroMotoristas extends javax.swing.JFrame {

    public TelaCadastroMotoristas() {
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {

        MotoristaService service = new MotoristaService();

        try {

            String[] colunas = new String[]{
                "ID", "Nome", "CPF", "RG", "Sexo", "Email",
                "Telefone", "CnhCategoria", "CnhEmissao",
                "cnhNumero", "Endereco"
            };

            List<Motorista> lista = service.listarMotoristas();

            Object[][] dados = new Object[lista.size()][colunas.length];

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            for (int i = 0; i < lista.size(); i++) {

                Motorista m = lista.get(i);

                dados[i][0] = m.getId();
                dados[i][1] = m.getNome();
                dados[i][2] = m.getCpf();
                dados[i][3] = m.getRg();
                dados[i][4] = m.getSexo();
                dados[i][5] = m.getEmail();
                dados[i][6] = m.getTelefone();
                dados[i][7] = m.getCnhCategoria();

                Date data = m.getCnhEmissao();

                dados[i][8] = (data != null)
                        ? formatter.format(data)
                        : "";

                dados[i][9] = m.getCnhNumero();
                dados[i][10] = m.getEndereco();
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

            tabelaMotoristas.setModel(modelo);

            if (tabelaMotoristas.getColumnModel().getColumnCount() > 0) {

                tabelaMotoristas.getColumnModel().getColumn(0).setMinWidth(0);
                tabelaMotoristas.getColumnModel().getColumn(0).setMaxWidth(0);
                tabelaMotoristas.getColumnModel().getColumn(0).setWidth(0);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados do banco: " + e.getMessage());
        }
    }

    public void limparCampos() {
        txtNome.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        buttonGroup1.clearSelection();
        txtEmail.setText("");
        txtTelefone.setText("");
        cbCnhCategoria.setSelectedIndex(0);
        txtDataEmissao.setText("");
        txtNumCnh.setText("");
        txtEndereco.setText("");
        txtNome.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnInserir = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        cbCnhCategoria = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtEndereco = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaMotoristas = new javax.swing.JTable();
        txtDataEmissao = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtNumCnh = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        jLabel8.setText("N° CNH:");

        jLabel9.setText("Sexo:");

        jLabel11.setText("CNH Categoria:");

        jLabel12.setText("CNH Data Emissão:");

        jLabel1.setFont(new java.awt.Font("Brush Script MT", 0, 36)); // NOI18N
        jLabel1.setText("Transportes Vrum Vrum");

        jLabel2.setText("Cadastro de Motoristas");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        jLabel4.setText("RG:");

        jLabel5.setText("Email:");

        jLabel6.setText("Telefone:");

        buttonGroup1.add(rbMasculino);
        rbMasculino.setText("Masculino");

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");

        jLabel7.setText("CPF:");

        cbCnhCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma opção:", "A", "B", "C", "D", "E" }));

        jLabel10.setText("Endereço:");

        tabelaMotoristas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "RG", "Sexo", "Email", "Telefone", "CNH Categoria", "CNH Data Emissão", "N° CNH", "Endereço"
            }
        ));
        tabelaMotoristas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMotoristasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaMotoristas);

        try {
            txtDataEmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDataEmissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataEmissaoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Listagem de Motoristas:");

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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(265, 265, 265)
                        .addComponent(btnEditar)
                        .addGap(26, 26, 26)
                        .addComponent(btnExcluir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 282, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addComponent(jLabel2)))
                        .addGap(333, 333, 333))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel9))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                        .addComponent(txtNome)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(rbMasculino)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(rbFeminino)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtRg, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                        .addComponent(txtCpf)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(71, 71, 71)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cbCnhCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtTelefone)))
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel10))
                                        .addGap(68, 68, 68)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                            .addComponent(txtNumCnh)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addGap(228, 228, 228)))
                        .addGap(138, 138, 138))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(btnInserir)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMasculino)
                            .addComponent(rbFeminino)
                            .addComponent(jLabel9))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbCnhCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtDataEmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtNumCnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnInserir)
                .addGap(24, 24, 24)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        //Validando se os campos foram preenchidos
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Nome do motorista.");
            txtNome.requestFocus();
        } else if (txtCpf.getText().isEmpty() || txtCpf.getText().equals("   .   .   -  ")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CPF do motorista.");
            txtCpf.requestFocus();
        } else if (txtRg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o RG do motorista.");
            txtRg.requestFocus();
        } else if (!rbMasculino.isSelected() & !rbFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe o sexo do motorista. .");
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Email do motorista.");
        } else if (txtTelefone.getText().isEmpty() || txtTelefone.getText().equals("(  )      -    ")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Telefone do motorista.");
            txtTelefone.requestFocus();
        } else if (cbCnhCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a categoria da CNH do motorista.");
        } else if (txtDataEmissao.getText().isEmpty() || txtDataEmissao.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a data da emissão da CNH do motorista.");
            txtDataEmissao.requestFocus();
        } else if (txtNumCnh.getText().isEmpty() || txtNumCnh.equals("           ")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Número da CNH do motorista.");
            txtNumCnh.requestFocus();
        } else if (txtEndereco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Endereço do motorista.");
            txtEndereco.requestFocus();
        } else {
            Motorista m = null;

            java.util.Date cnhEmissao = null;

            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                cnhEmissao = sdf.parse(txtDataEmissao.getText());

                m = new Motorista(
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtRg.getText(),
                        rbMasculino.isSelected() ? 'M' : 'F',
                        txtEmail.getText(),
                        txtTelefone.getText(),
                        cbCnhCategoria.getSelectedItem().toString(),
                        cnhEmissao,
                        txtNumCnh.getText(),
                        txtEndereco.getText()
                );

            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro no Formato da data. Por favor, utilize dd/MM/yyyy.");
                txtDataEmissao.requestFocus();
                return;
            }

            try {
                //instancia MotoristaService para poder acessar o metodo inserir
                MotoristaService service = new MotoristaService();

                service.inserirMotorista(m);

                JOptionPane.showMessageDialog(null, "Motorista " + m.getNome() + " inserido(a) com sucesso no banco de dados.");

                limparCampos();

                atualizarTabela();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao inserir o motorista no banco." + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //pega a linha selecionada
        int linhaSelecionada = tabelaMotoristas.getSelectedRow();
        //testa se alguma linha foi selecionada
        if (linhaSelecionada == -1) {
            //mensagem de erro caso uma linha nao tenha sido escolhida
            JOptionPane.showMessageDialog(null, "Selecione um motorista para excluir.");
            return;
        }

        //pega o id do registro selecionado
        int idParaExcluir = (int) tabelaMotoristas.getModel().getValueAt(linhaSelecionada, 0);

        //confirmacao para excluir
        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "tem certeza que deseja excluir o motorista?",
                "confirmar exclusao",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {

            try {
                //instancia a clase MotoristaService
                MotoristaService service = new MotoristaService();

                //chama o metodo que exclui o motorista
                service.excluirMotorista(idParaExcluir);

                //mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Motorista excluido com sucesso.");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void tabelaMotoristasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMotoristasMouseClicked
        btnInserir.setEnabled(false);
        btnEditar.setEnabled(true);

        int linhaEdicao = tabelaMotoristas.getSelectedRow();
        if (linhaEdicao != -1) {
            txtNome.setText(tabelaMotoristas.getValueAt(linhaEdicao, 1).toString());
            buttonGroup1.clearSelection();
            txtCpf.setText(tabelaMotoristas.getValueAt(linhaEdicao, 2).toString());
            txtRg.setText(tabelaMotoristas.getValueAt(linhaEdicao, 3).toString());
            txtEmail.setText(tabelaMotoristas.getValueAt(linhaEdicao, 5).toString());
            txtTelefone.setText(tabelaMotoristas.getValueAt(linhaEdicao, 6).toString());
            cbCnhCategoria.setSelectedIndex(0);
            txtDataEmissao.setText(tabelaMotoristas.getValueAt(linhaEdicao, 8).toString());
            txtNumCnh.setText(tabelaMotoristas.getValueAt(linhaEdicao, 9).toString());
            txtEndereco.setText(tabelaMotoristas.getValueAt(linhaEdicao, 10).toString());
            txtNome.requestFocus();
        }
    }//GEN-LAST:event_tabelaMotoristasMouseClicked

    private void txtDataEmissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataEmissaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataEmissaoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //valida se todos os campos foram preenchidos devidamente
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Nome do Motorista.");
            txtNome.requestFocus();
        } else if (txtCpf.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CPF do Motorista.");
            txtCpf.requestFocus();
        } else if (txtRg.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o RG do Motorista.");
            txtRg.requestFocus();
        } else if (!rbMasculino.isSelected() && !rbFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione o sexo do Motorista.");
            rbMasculino.requestFocus();
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Email do Motorista.");
            txtEmail.requestFocus();
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Telefone do Motorista.");
            txtTelefone.requestFocus();
        } else if (cbCnhCategoria.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Por favor, selecione a Categoria da CNH do Motorista.");
        } else if (txtDataEmissao.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Data de Emissão da CNH do Motorista.");
            txtDataEmissao.requestFocus();
        } else if (txtNumCnh.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o número da CNH do Motorista.");
            txtNumCnh.requestFocus();
        } else if (txtEndereco.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Endereço do Motorista.");

            //se tudo estiver preenchido, pega o valor do cpf da linha selecionada na JTable, manda remover da lista
        } else {
            int linhaSelecionada = tabelaMotoristas.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada para edição.");
                return;
            }
            int idParaEditar = (int) tabelaMotoristas.getModel().getValueAt(linhaSelecionada, 0);

            java.util.Date dataEmissao = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dataEmissao = sdf.parse(txtDataEmissao.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro no Formato da data. Por favor, utilize dd/MM/yyyy.");
                txtDataEmissao.requestFocus();
                return;
            }

            Motorista m = new Motorista(
                    txtNome.getText(),
                    txtCpf.getText(),
                    txtRg.getText(),
                    rbMasculino.isSelected() ? 'M' : 'F',
                    txtEmail.getText(),
                    txtTelefone.getText(),
                    cbCnhCategoria.getSelectedItem().toString(),
                    dataEmissao,
                    txtNumCnh.getText(),
                    txtEndereco.getText()
            );

            m.setId(idParaEditar);

            try {
                MotoristaService service = new MotoristaService();
                service.excluirMotorista(idParaEditar);

                JOptionPane.showMessageDialog(null, "Motorista " + m.getNome() + " editado com sucesso!");

                limparCampos();
                atualizarTabela();
                btnInserir.setEnabled(true);
                btnEditar.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar o motorista: " + e.getMessage());
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
            java.util.logging.Logger.getLogger(TelaCadastroMotoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMotoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMotoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroMotoristas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroMotoristas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbCnhCategoria;
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
    private javax.swing.JRadioButton rbFeminino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTable tabelaMotoristas;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtDataEmissao;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumCnh;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
