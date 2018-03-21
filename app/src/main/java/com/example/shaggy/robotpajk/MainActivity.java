package com.example.shaggy.robotpajk;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    //private final String DEVICE_ADDRESS = "20:16:10:20:46:71";
    private final String DEVICE_ADDRESS = "20:15:08:19:85:40";
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    ImageButton forward_btn, forward_left_btn, forward_right_btn, reverse_btn;
    CardView bluetooth_connect_btn, bluetooth_disconnect_btn;
    Spinner spinner;
    TextView s, creators, nameOfProject;
    String command;
    private int spinner_options;

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView spinnerDialogText = (TextView) view;
        Toast.makeText(this, "you selected " + spinnerDialogText.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        forward_btn = (ImageButton) findViewById(R.id.forward_btn);
        forward_left_btn = (ImageButton) findViewById(R.id.forward_left_btn);
        forward_right_btn = (ImageButton) findViewById(R.id.forward_right_btn);
        reverse_btn = (ImageButton) findViewById(R.id.reverse_btn);
        creators = (TextView) findViewById(R.id.creators);
        nameOfProject = (TextView) findViewById(R.id.nameOfProject);
        bluetooth_connect_btn = (CardView) findViewById(R.id.bluetooth_connect_btn);
        bluetooth_disconnect_btn = (CardView) findViewById(R.id.bluetooth_disconnect_btn);
        forward_btn.setEnabled(false);
        forward_left_btn.setVisibility(View.INVISIBLE);
        forward_right_btn.setVisibility(View.INVISIBLE);
        reverse_btn.setVisibility(View.INVISIBLE);
        forward_btn.setVisibility(View.INVISIBLE);
        bluetooth_connect_btn.setVisibility(View.VISIBLE);
        bluetooth_disconnect_btn.setVisibility(View.INVISIBLE);
        creators.setVisibility(View.VISIBLE);
        nameOfProject.setVisibility(View.VISIBLE);
        forward_left_btn.setEnabled(false);
        forward_right_btn.setEnabled(false);
        reverse_btn.setEnabled(false);
        bluetooth_disconnect_btn.setEnabled(false);


        forward_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "1";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "5";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                return false;
            }
        });

        reverse_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "2";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "6";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                return false;
            }
        });

        forward_left_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "3";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "7";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                return false;
            }
        });


        forward_right_btn.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "4";

                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "8";
                    try
                    {
                        outputStream.write(command.getBytes());
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }
                    catch (Exception e)
                    {
                        e.getMessage();
                    }
                }
                return false;
            }
        });


        bluetooth_connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BTinit())
                {
                    BTconnect();
                }
                refreshButton();
            }
        });

        bluetooth_disconnect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                refreshButton();
            }
        });
    }

    void refreshButton(){

        if (socket.isConnected())
        {
            forward_btn.setEnabled(true);
            forward_left_btn.setEnabled(true);
            forward_right_btn.setEnabled(true);
            reverse_btn.setEnabled(true);
            bluetooth_disconnect_btn.setEnabled(true);
            bluetooth_connect_btn.setEnabled(false);
            bluetooth_disconnect_btn.setVisibility(View.VISIBLE);
            bluetooth_connect_btn.setVisibility(View.VISIBLE);
            forward_left_btn.setVisibility(View.VISIBLE);
            forward_right_btn.setVisibility(View.VISIBLE);
            reverse_btn.setVisibility(View.VISIBLE);
            forward_btn.setVisibility(View.VISIBLE);
            creators.setVisibility(View.INVISIBLE);
        }
        else
        {
            forward_btn.setEnabled(false);
            forward_left_btn.setEnabled(false);
            forward_right_btn.setEnabled(false);
            reverse_btn.setEnabled(false);
            bluetooth_disconnect_btn.setEnabled(false);
            bluetooth_connect_btn.setEnabled(true);
            bluetooth_disconnect_btn.setVisibility(View.INVISIBLE);
            bluetooth_connect_btn.setVisibility(View.VISIBLE);
            forward_left_btn.setVisibility(View.INVISIBLE);
            forward_right_btn.setVisibility(View.INVISIBLE);
            reverse_btn.setVisibility(View.INVISIBLE);
            forward_btn.setVisibility(View.INVISIBLE);
            creators.setVisibility(View.VISIBLE);
        }
    }


    public boolean BTinit()
    {
        boolean found = false;

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if(bluetoothAdapter == null)
        {
            Toast.makeText(getApplicationContext(), "Device doesn't support bluetooth", Toast.LENGTH_SHORT).show();
        }

        if(!bluetoothAdapter.isEnabled())
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter,0);

            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

        if(bondedDevices.isEmpty())
        {
            Toast.makeText(getApplicationContext(), "Please pair the device first", Toast.LENGTH_SHORT).show();
        }
        else
        {
            for(BluetoothDevice iterator : bondedDevices)
            {
                if(iterator.getAddress().equals(DEVICE_ADDRESS))
                {
                    device = iterator;
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public boolean BTconnect()
    {
        boolean connected = true;

        try
        {
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID);
            socket.connect();

            Toast.makeText(getApplicationContext(),
                    "Pomyślnie połączono z ARAÑA", Toast.LENGTH_LONG).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            connected = false;
        }

        if(connected)
        {
            try
            {
                outputStream = socket.getOutputStream();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return connected;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
}