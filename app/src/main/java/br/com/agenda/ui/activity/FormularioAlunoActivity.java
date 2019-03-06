package br.com.agenda.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.agenda.R;
import br.com.agenda.dao.AlunoDAO;
import br.com.agenda.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Novo Aluno";
    private EditText campoNome;
    private EditText campoTelefone;
    private EditText campoEmail;
    final AlunoDAO alunoDao = new AlunoDAO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_aluno);
        setTitle(TITULO_APPBAR);
        inicializaVariaveis();
        configuraBotaoSalvar();
    }

    private void configuraBotaoSalvar() {
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(FormularioAlunoActivity.this,
//                        "Cliquei no botão salvar",
//                        Toast.LENGTH_SHORT).show();
                Aluno alunoCriado = criaAluno();

                salvaAluno(alunoCriado);

//                startActivity(new Intent(FormularioAlunoActivity.this,
//                        ListaAlunosActivity.class));

//                Toast.makeText(FormularioAlunoActivity.this,
//                        alunoCriado.getNome() + " "
//                                + alunoCriado.getTelefone() + " "
//                                + alunoCriado.getEmail(),
//                        Toast.LENGTH_SHORT).show();


            }
        });
    }

    private void inicializaVariaveis() {
        campoNome = findViewById(R.id.activity_formulario_aluno_nome);
        campoTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        campoEmail = findViewById(R.id.activity_formulario_aluno_email);
    }

    private void salvaAluno(Aluno aluno) {
        alunoDao.salvar(aluno);
        finish();
    }

    @NonNull
    private Aluno criaAluno() {
        String nome = campoNome.getText().toString();
        String telefone = campoTelefone.getText().toString();
        String email = campoEmail.getText().toString();

        return new Aluno(nome, telefone, email);
    }
}
