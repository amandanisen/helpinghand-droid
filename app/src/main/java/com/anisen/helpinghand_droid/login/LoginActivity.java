package com.anisen.helpinghand_droid.login;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//
//import io.realm.Realm;
//import io.realm.RealmConfiguration;
//import io.realm.exceptions.RealmMigrationNeededException;

public class LoginActivity extends AppCompatActivity {
//    private static final String TAG = "LoginActivity";
//
//    private String username;
//    private String password;
//
//    //part of view controller
//    private TextView mTvStatus;
//    private ProgressBar mProgressBar;
//    private EditText mEmailText;
//    private EditText mPasswordText;
//    private Button mLoginButton;
//    private TextView _signupLink;
//
//    private BroadcastReceiver mBroadcastReceiver;
//
//    protected AuthenticationClient mAuthenticationClient;
//
//    //setting up context
//    public static Context contextOfApplication;
//
//    boolean isSyncing = false;
//
//    private ScheduledExecutorService mExecutor = Executors.newSingleThreadScheduledExecutor();
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        firstRun(); //initialize realm
////        ButterKnife.bind(this);
//        mTvStatus = findViewById(R.id.status);
//        mProgressBar = findViewById(R.id.progress_horizontal);
//        mEmailText = findViewById(R.id.input_email);
//        mPasswordText = findViewById(R.id.input_password);
//        mLoginButton = findViewById(R.id.btn_login);
//
//        //changing color of the button
//        mLoginButton.setBackgroundColor(getResources().getColor(R.color.backgroundButtonPurple));
//        //login button listener
//        //when user clicks login
//        //it will validate first
//        //then try to login to Customer Portal
//        mLoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });
//        contextOfApplication = LoginActivity.this;
//    }
//
//
//    private void retrieveUserCreds(){
//        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
//        this.username = sharedPref.getString("username","");
//        System.out.println("this.user: " + username);
//        password = sharedPref.getString("password","");
//    }
//
//    private void showNetworkProgress(boolean visible) {
//        mProgressBar.setVisibility(visible ? View.VISIBLE : View.GONE);
////        mCancel.setVisibility(visible ? View.VISIBLE : View.GONE);
//    }
//
//    public static Context getContextOfApplication(){
//        return contextOfApplication;
//    }
//
//
//    @Override
//    protected void onResume() {
//        Log.i(TAG, "**On Resume**");
//        super.onResume();
//        syncLocalBroadcastManager();
//    }
//
//    private void syncLocalBroadcastManager(){
//        IntentFilter filter = new IntentFilter();
//        filter.addAction(OktaAuthentication.BROADCAST_SYNC_UPDATE);
//        mBroadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent)
//            {
//                if (intent.hasExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_STATE))
//                {
//                    if (intent.getBooleanExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_STATE, true))
//                    {
//                        isSyncing = true;
//                        Toast.makeText(LoginActivity.this, "Signing in.", Toast.LENGTH_SHORT).show();
//                        Log.i(TAG, "Sync Started.");
//                    }
//                }else if(intent.hasExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_SUCCESSFUL)){
//                    // if it is done syncing, then stop the progress bar and move activity to summary ticket vie
//                    if(intent.getBooleanExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_SUCCESSFUL, true)){
//                        showNetworkProgress(false);
//                        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                        final String accessToken = prefs.getString("access_token", "");
//                        System.out.println("accessToken in login activity: " + accessToken);
//                        mTvStatus.setText("Authorized!");
//                        onLoginSuccess();
//                    }
//                } else if (intent.hasExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_FAILURE))
//                {
//                    if (intent.getBooleanExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_FAILURE, true))
//                    {
//                        showNetworkProgress(false);
//                        String failureReason = intent.getStringExtra(OktaAuthentication.EXTRA_BROADCAST_SYNC_FAILURE_REASON);
////                        mTvStatus.setText("An error has occurred: " + failureReason);
//                        onLoginFailed();
//                    }
//                }
//
//            }
//        };
//
//        LocalBroadcastManager.getInstance(LoginActivity.this)
//                .registerReceiver(mBroadcastReceiver, filter);
//    }
//
//    public void login() {
//        Log.d(TAG, "Login");
//
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }
//
//        mLoginButton.setEnabled(false);
//
//        String email = mEmailText.getText().toString();
//        String password = mPasswordText.getText().toString();
//
//
//        // TODO: Implement your own authentication logic here.
////        onSignIn(email, password);
//        setUpSignin(email, password);
//    }
//
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
////        if (requestCode == REQUEST_SIGNUP) {
////            if (resultCode == RESULT_OK) {
////
////                // TODO: Implement successful signup logic here
////                // By default we just finish the Activity and log them in automatically
////                this.finish();
////            }
////        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        // disable going back to the MainActivity
//        moveTaskToBack(true);
//    }
//
//    public void onLoginSuccess() {
//        mLoginButton.setEnabled(false);
//        //TODO: have intent to another view controller
//        Intent intent = new Intent(this, TicketSummaryActivity.class);
//        intent.putExtra("login", true);
//        startActivity(intent);
//    }
//
//    public void onLoginFailed() {
//        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
//        mLoginButton.setEnabled(true);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String email = mEmailText.getText().toString();
//        String password = mPasswordText.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            mEmailText.setError("Please enter a valid email address");
//            valid = false;
//        } else {
//            mEmailText.setError(null);
//        }
//
//        if (password.isEmpty()) {
//            mPasswordText.setError("Please enter your password");
//            valid = false;
//        } else {
//            mPasswordText.setError(null);
//        }
//
//        return valid;
//    }
//
//    private void setUpSessionTokenRetrieval(String username, String password){
//        OktaAuthentication.startActionGetSessionToken(this.getApplicationContext(), username, password);
//
//    }
//
//    private void setUpSignin(String username, String password){
//        showNetworkProgress(true);
//        OktaAuthentication.startActionAuthenticate(this.getApplicationContext(), username, password);
//    }
//
//
//
//
//
//
//
//    private void firstRun()
//    {
//        //if user and pass != null, they are logged in
//        //skip loginActivity
//        retrieveUserCreds();
//        //TODO: have to check if access_token is expired
//        System.out.println("Username: "+ username);
//        if(username!= null && password != null){
//            if(!username.equals("") && !password.equals("")) {
//                Intent intent = new Intent(this, TicketSummaryActivity.class);
//                intent.putExtra("login", true);
//                startActivity(intent);
//            }
//        }
//        Realm.init(this);
//        RealmConfiguration realmConfig = new RealmConfiguration.Builder().name("myREC.realm").build();
//        Realm.setDefaultConfiguration(realmConfig);
//        Realm realm;
//        try {
//        }catch (RealmMigrationNeededException ex){
//            Realm.deleteRealm(realmConfig);
//
//            realmConfig = new RealmConfiguration.Builder().name("myREC.realm").build();
//            Realm.setDefaultConfiguration(realmConfig);
//        }
//
//
//    }
}