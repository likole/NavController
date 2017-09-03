package cn.likole.navcontroller;

        import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;
    private Button button_f;
    private Button button_b;
    private Button button_l;
    private Button button_r;
    private Button button_s;
    private EditText editText;

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindView();
        setListener();
        new Thread(new Runnable() {
            @Override
            public void run() {
                client=new Client(MainActivity.this);
            }
        }).start();
    }

    private void bindView(){
        button= (Button) findViewById(R.id.button);
        button_l= (Button) findViewById(R.id.button_l);
        button_r= (Button) findViewById(R.id.button_r);
        button_f= (Button) findViewById(R.id.button_fd);
        button_b= (Button) findViewById(R.id.button_bk);
        button_s= (Button) findViewById(R.id.button_send);
        editText= (EditText) findViewById(R.id.editText);
    }

    private void setListener(){
        button.setOnClickListener(this);
        button_l.setOnClickListener(this);
        button_r.setOnClickListener(this);
        button_b.setOnClickListener(this);
        button_f.setOnClickListener(this);
        button_s.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg("reset");
                        client.sendMessage();
                    }
                }).start();
                break;
            case R.id.button_l:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg("l");
                        client.sendMessage();
                    }
                }).start();
                break;
            case R.id.button_r:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg("r");
                        client.sendMessage();
                    }
                }).start();
                break;
            case R.id.button_fd:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg("fd");
                        client.sendMessage();
                    }
                }).start();
                break;
            case R.id.button_bk:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg("bk");
                        client.sendMessage();
                    }
                }).start();
                break;
            case R.id.button_send:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        client.setMsg(editText.getText().toString());
                        client.sendMessage();
                    }
                }).start();
                break;
        }
    }
}
