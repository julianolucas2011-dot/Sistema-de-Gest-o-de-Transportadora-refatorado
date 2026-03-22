/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

//import dao.FuncionarioDAO;
import service.FuncionarioService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import conexao.Conexao;
import java.sql.*;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Juliano
 */
public class TelaCadastroFuncionarios extends javax.swing.JFrame {

    public TelaCadastroFuncionarios() {
        initComponents();
        atualizarTabela();
    }

    public void atualizarTabela() {
        FuncionarioService service = new FuncionarioService();
        try {
            String[] colunas = new String[]{"ID", "Nome", "Sexo", "RG", "Email", "Telefone", "CPF", "Nascimento"};

            List<Funcionario> lista = service.listarFuncionarios();

            Object[][] dados = new Object[lista.size()][colunas.length];

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            for (int i = 0; i < lista.size(); i++) {
                Funcionario f = lista.get(i);

                dados[i][0] = f.getId();
                dados[i][1] = f.getNome();
                dados[i][2] = f.getSexo();
                dados[i][3] = f.getRg();
                dados[i][4] = f.getEmail();
                dados[i][5] = f.getTelefone();
                dados[i][6] = f.getCpf();
                java.util.Date data = f.getDataNascimento();
                dados[i][7] = (data != null)
                        ? formatter.format(data)
                        : "";
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
            tabelaFuncionarios.setModel(modelo);

            if (tabelaFuncionarios.getColumnModel().getColumnCount() > 0) {
                tabelaFuncionarios.getColumnModel().getColumn(0).setMinWidth(0);
                tabelaFuncionarios.getColumnModel().getColumn(0).setMaxWidth(0);
                tabelaFuncionarios.getColumnModel().getColumn(0).setWidth(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar dados do banco: " + e.getMessage());
        }
    }

    public void limparCampos() {
        txtNome.setText("");
        buttonGroup1.clearSelection();
        txtRg.setText("");
        txtEmail.setText("");
        txtTelefone.setText("");
        txtCpf.setText("");
        txtData.setText("");
        txtNome.requestFocus();
    }

    /*public void excluir(int linha) {
        tabelaFuncionarios.remove(linha);
    }*/
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rbMasculino = new javax.swing.JRadioButton();
        rbFeminino = new javax.swing.JRadioButton();
        txtData = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        btnInserir = new javax.swing.JButton();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        txtRg = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTelefone = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaFuncionarios = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Brush Script MT", 0, 36)); // NOI18N
        jLabel2.setText("Transportes Vrum Vrum");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Cadastro de funcionários:");

        jLabel4.setText("CPF:");

        jLabel5.setText("RG:");

        jLabel6.setText("Email:");

        jLabel7.setText("Telefone:");

        jLabel8.setText("Sexo:");

        buttonGroup1.add(rbMasculino);
        rbMasculino.setText("Masculino");

        buttonGroup1.add(rbFeminino);
        rbFeminino.setText("Feminino");

        txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        txtData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDataMouseEntered(evt);
            }
        });

        jLabel9.setText("Data nascimento:");

        btnInserir.setText("Inserir");
        btnInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInserirActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        tabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Sexo", "RG", "Email", "Telefone", "CPF", "Data Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaFuncionarios);

        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("ex: 01/02/2002");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.setEnabled(false);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Funcionários cadastrados:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(btnEditar)
                        .addGap(33, 33, 33)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(372, 372, 372)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(356, 356, 356)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 78, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(btnInserir))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(rbMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbFeminino)))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32)
                                .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rbMasculino)
                                .addComponent(rbFeminino))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8))))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExcluir)
                            .addComponent(btnEditar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(btnInserir)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInserirActionPerformed
        //validacao dos campos para recuperar todos os dados corretamente
        if (txtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Nome do Funcionário.");
            txtNome.requestFocus();
        } else if (!rbMasculino.isSelected() & !rbFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe o sexo do Funcionário.");
            rbMasculino.requestFocus();
        } else if (txtRg.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o RG do Funcionário.");
            txtRg.requestFocus();
        } else if (txtEmail.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Email do Funcionário.");
            txtEmail.requestFocus();
        } else if (txtTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Telefone do Funcionário.");
            txtTelefone.requestFocus();
        } else if (txtCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CPF do Funcionário.");
            txtCpf.requestFocus();
        } else if (txtData.getText().isEmpty() || txtData.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Data de Nascimento do Funcionário.\n                                    ex: 01/02/2002");
            txtData.requestFocus();

        } else {
            //cria uma variavel do tipo Funcionario como null
            Funcionario f = null;

            //cria uma variavel do tipo Date como null
            java.util.Date dataNascimento = null;

            //abre o bloco try pra poder converter a data e tratar a mesma em caso de erros
            try {
                //Dentro do bloco try, cria uma variavel do tipo SimpleDateFormat e passa como parametro o formato da data
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                //converte a string txtData(TextField do formulario que recebe a data digitada pelo usuario) atraves do metodo da variavel sdf: (sdf.parse(txtData.gettext()))
                //e joga dentro da variavel dataNascimento do tipo Date que sera passada ao atributo dataNascimento do obj Funcionario que sera criado na sequencia
                dataNascimento = sdf.parse(txtData.getText());

                //popula os atributos do obj Funcionario com os valores dos componentes do formulario conforme os parametros do construtor na classe Funcionario
                f = new Funcionario(
                        txtNome.getText(),
                        txtCpf.getText(),
                        txtRg.getText(),
                        txtEmail.getText(),
                        txtTelefone.getText(),
                        rbMasculino.isSelected() ? 'M' : 'F',
                        dataNascimento
                );

                //tratamento caso a data seja inserida da maneira incorreta  
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro no Formato da data. Por favor, utilize dd/MM/yyyy.");
                txtData.requestFocus();
                return;
            }

            //abre o bloco try pra tentar realizar a insercao do funcionario no banco
            try {
                //instancia funcionarioService para poder acessar o metodo inserir
                FuncionarioService service = new FuncionarioService();

                //passa o obj funcionario
                service.inserirFuncionario(f);

                //mensagem de sucesso ao inserir o funcionario
                JOptionPane.showMessageDialog(null, "Funcionario(a) " + f.getNome() + " inserido(a) com sucesso no banco de dados.");

                //limpa os campos
                limparCampos();

                //atualiza a tabela
                atualizarTabela();

            } catch (Exception e) {
                //mensagem de erro caso a insercao nao ocorra
                JOptionPane.showMessageDialog(null, "Erro ao inserir o funcionario no banco." + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnInserirActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataMouseEntered

    private void txtDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDataMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        //pega a linha selecionada
        int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
        //testa se alguma linha foi selecionada
        if (linhaSelecionada == -1) {
            //mensagem de erro caso uma linha nao tenha sido escolhida
            JOptionPane.showMessageDialog(null, "Selecione um funcionario para excluir.");
            return;
        }

        //pega o id do registro selecionado
        int idParaExcluir = (int) tabelaFuncionarios.getModel().getValueAt(linhaSelecionada, 0);

        //confirmacao para excluir
        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "tem certeza que deseja excluir o funcionario?",
                "confirmar exclusao",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {

            try {
                FuncionarioService service = new FuncionarioService();

                //chama o metodo que exclui o funcionario
                service.excluirFuncionario(idParaExcluir);

                //mensagem de sucesso
                JOptionPane.showMessageDialog(null, "Funcionario excluido com sucesso.");
                atualizarTabela();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao excluir: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_btnExcluirActionPerformed


    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        //Testa se todos os campos foram preenchidos
        if (txtNome.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Nome do Funcionário.");
        } else if (!rbMasculino.isSelected() & !rbFeminino.isSelected()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe o sexo do Funcionário.");
        } else if (txtRg.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o RG do Funcionário.");
        } else if (txtEmail.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Email do Funcionário.");
        } else if (txtTelefone.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o Telefone do Funcionário.");
        } else if (txtCpf.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, digite o CPF do Funcionário.");
        } else if (txtData.getText().isEmpty() || txtData.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor, informe a Data de Nascimento do Funcionário.\n                                    ex: 01/02/2002");
        } else {

            int linhaSelecionada = tabelaFuncionarios.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(null, "Nenhuma linha selecionada para edição.");
                return;
            }
            int idParaEditar = (int) tabelaFuncionarios.getModel().getValueAt(linhaSelecionada, 0);

            java.util.Date dataNascimento = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dataNascimento = sdf.parse(txtData.getText());
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Erro no Formato da data. Por favor, utilize dd/MM/yyyy.");
                txtData.requestFocus();
                return;
            }

            Funcionario f = new Funcionario(
                    txtNome.getText(),
                    txtCpf.getText(),
                    txtRg.getText(),
                    txtEmail.getText(),
                    txtTelefone.getText(),
                    rbMasculino.isSelected() ? 'M' : 'F',
                    dataNascimento
            );
            f.setId(idParaEditar);

            try {
                FuncionarioService service = new FuncionarioService();
                service.editarFuncionario(f);

                JOptionPane.showMessageDialog(null, "Funcionario " + f.getNome() + " editado com sucesso!");

                limparCampos();
                atualizarTabela();
                btnInserir.setEnabled(true);
                btnEditar.setEnabled(false);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao editar o funcionário no banco: " + e.getMessage());
            }

        }
    }//GEN-LAST:event_btnEditarActionPerformed


    private void tabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaFuncionariosMouseClicked
        btnInserir.setEnabled(false);
        btnEditar.setEnabled(true);

        int linhaEdicao = tabelaFuncionarios.getSelectedRow();
        if (linhaEdicao != -1) {
            txtNome.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 1).toString());
            buttonGroup1.clearSelection();
            txtCpf.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 6).toString());
            txtRg.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 3).toString());
            txtEmail.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 4).toString());
            txtTelefone.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 5).toString());
            txtData.setText(tabelaFuncionarios.getValueAt(linhaEdicao, 7).toString());
            txtNome.requestFocus();

    }//GEN-LAST:event_tabelaFuncionariosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroFuncionarios.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnInserir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTable tabelaFuncionarios;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
