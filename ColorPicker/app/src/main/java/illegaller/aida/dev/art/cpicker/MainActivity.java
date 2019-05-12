package illegaller.aida.dev.art.cpicker;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.pes.androidmaterialcolorpickerdialog.*;

public class MainActivity extends Activity 
{
    //* target yang akan di warnai **/
    LinearLayout linier;
    
    
    //* TextView Sebagai Tombol untuk menampilkan dialog nya */
    TextView txt;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //** panggil object dengan id disini **//
        linier = (LinearLayout)findViewById(R.id.mainLinearLayout);
        txt = (TextView)findViewById(R.id.mainTextView);
        //* membuat onclick di textView dengan eventListener **/
        txt.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View p1)
            {
                // menampilkan dialog colorPicker **/
                final ColorPicker cpicker = new ColorPicker(MainActivity.this, 0, 0, 0);
                cpicker.show();
                
                // memilih warna dan menerapkan di target linearlayout sebagai latar belakang **/
                Button btn = (Button)cpicker.findViewById(R.id.okColorButton);
                
                btn.setOnClickListener(new OnClickListener()
                {
                    
                    public void onClick(View p1)
                    {
                        int selectedcolor = cpicker.getColor();
                        linier.setBackgroundColor(selectedcolor);
                        cpicker.dismiss();
                        
                    }
                });
                
            }
        });
        
    }
}
