package com.example.cr7.chatapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.cr7.Fragment.MDatePicker;
import com.example.cr7.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;


public class EditInfoActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @BindView(R.id.imgSUAvatar)
    ImageView imgAvatar;
    @BindView(R.id.txtFName)
    EditText txtFName;
    @BindView(R.id.txtLName)
    EditText txtLName;
    @BindView(R.id.txtEmail)
    EditText txtEmail;
    @BindView(R.id.txtPass)
    EditText txtPass;
    @BindView(R.id.txtBirthday)
    EditText txtBirthday;
    @BindView(R.id.rdMale)
    RadioButton ckbMale;
    @BindView(R.id.rdFemale)
    RadioButton ckbFemale;
    @BindView(R.id.input_firstName)
    TextInputLayout input_firstName;
    @BindView(R.id.input_lastname)
    TextInputLayout input_lastname;
    @BindView(R.id.input_email)
    TextInputLayout input_email;
    @BindView(R.id.input_pass_email)
    TextInputLayout input_pass_email;
    @BindView(R.id.input_birthday)
    TextInputLayout input_birthday;
    @BindView(R.id.btnCreate)
    Button btnCreate;
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eidt_info);
        ButterKnife.bind(this);
        getSupportActionBar().hide();
        addControls();
        addEvents();
    }

    private void addEvents() {

        txtFName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > input_firstName.getCounterMaxLength())
                    input_firstName.setError("Max character length is " + input_firstName.getCounterMaxLength());
                else
                    input_firstName.setError(null);
            }
        });
        txtLName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() >= input_lastname.getCounterMaxLength()) {
                    input_lastname.setError("Max character length is " + input_lastname.getCounterMaxLength());
                } else input_lastname.setError(null);
            }
        });
        txtEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > input_email.getCounterMaxLength()) {
                    input_email.setError("Max character length is " + input_email.getCounterMaxLength());
                } else input_email.setError(null);
            }
        });
        txtPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > input_pass_email.getCounterMaxLength()) {
                    input_pass_email.setError("Max character length is " + input_pass_email.getCounterMaxLength());
                } else input_pass_email.setError(null);
            }
        });
        txtBirthday.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (txtBirthday.getRight() - txtBirthday.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        MDatePicker datePicker = new MDatePicker();
                        datePicker.show(getFragmentManager(), "Birthday");

                        return true;
                    }
                }
                return false;
            }
        });

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCreate();
            }
        });

        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    private void clickCreate() {
        if (txtFName.getText().toString().trim().equals("")) {
            txtFName.requestFocus();
            Toast.makeText(this, "Mời nhập tên User ", Toast.LENGTH_SHORT).show();
            return;
        } else if (txtLName.getText().toString().trim().equals("")) {
            txtLName.requestFocus();
            Toast.makeText(this, "Mời nhập tên User", Toast.LENGTH_SHORT).show();
        } else if (txtEmail.getText().toString().trim().equals("")) {
            txtEmail.requestFocus();
            Toast.makeText(this, "Mời nhập Email", Toast.LENGTH_SHORT).show();
        } else if (txtPass.getText().toString().trim().equals("")) {
            txtPass.requestFocus();
            Toast.makeText(this, "Mời nhập Password", Toast.LENGTH_SHORT).show();
        } else if (txtBirthday.getText().toString().trim().equals("")) {
            Toast.makeText(this, "Mời nhập ngày sinh", Toast.LENGTH_SHORT).show();
        } else {
            signUpProcess();
        }
    }

    public void showDialog() {

        if (mProgressDialog != null && !mProgressDialog.isShowing())
            mProgressDialog.show();
    }

    public void hideDialog() {

        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }

    private void signUpProcess() {
//        int gender = 1;
//        if (ckbMale.isChecked()) {
//            gender = 0;
//        }
//        final APIService apiService = RetrofitClient.getClient().create(APIService.class);
//        Call<User> call = apiService.addUser(txtEmail.getText().toString().trim(), txtPass.getText().toString().trim(),
//                txtFName.getText().toString().trim(), txtLName.getText().toString().trim(),
//                txtBirthday.getText().toString().trim(), gender, "https://www.biography.com/.image/t_share/MTE4MDAzNDEwNzg5ODI4MTEw/barack-obama-12782369-1-402.jpg");
//        showDialog();
//        Log.e("URL", call.request().url() + " ");
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                User user = response.body();
//                hideDialog();
//                if (user != null) {
//                    Toast.makeText(SignUpActivity.this, "Success!!!", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//                hideDialog();
//                Log.e("onFailure: ", "something fail mail");
//            }
//
//        });


    }

    private void addControls() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setIndeterminate(true);
        mProgressDialog.setMessage("Loading...");

        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("user");
        txtFName.setText(user.getfName());
        txtLName.setText(user.getlName());
        txtBirthday.setText(user.getBirthday());
        txtEmail.setText(user.getIdUser());
        txtPass.setText(user.getPass());
        if(user.getGender()==0){
            ckbFemale.setChecked(true);
            ckbMale.setChecked(false);
        }else{
            ckbFemale.setChecked(false);
            ckbMale.setChecked(true);
        }
        Glide.with(EditInfoActivity.this)
                .load(user.getAvatar())
                .into(imgAvatar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Bitmap image = getCroppedBitmap(imageBitmap);
            imgAvatar.setImageBitmap(image);
        }
    }

    public Bitmap getCroppedBitmap(Bitmap bitmap) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2,
                bitmap.getWidth() / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        //Bitmap _bmp = Bitmap.createScaledBitmap(output, 60, 60, false);
        //return _bmp;
        return output;
    }
}
