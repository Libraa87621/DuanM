package Login_SingIn;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dnmu.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ImageButton iconMenu = findViewById(R.id.iconMenu);
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });
    }

    private void showCustomDialog() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_menu);

        ListView menuListView = dialog.findViewById(R.id.menuListView);
        String[] menuItems = getResources().getStringArray(R.array.menu_items);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, menuItems);
        menuListView.setAdapter(adapter);

        menuListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = menuItems[position];
                Toast.makeText(UserActivity.this, selectedItem, Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                // Handle each item click here
                switch (position) {
                    case 0:
                        // Handle "Trang chủ" click
                        break;
                    case 1:
                        // Handle "Thuê xe" click
                        break;
                    case 2:
                        // Handle "Vé máy bay" click
                        break;
                    case 3:
                        // Handle "Liên hệ" click
                        break;
                    case 4:
                        // Handle "Giới thiệu" click
                        break;
                    case 5:
                        // Handle "Đăng xuất" click
                        break;
                }
            }
        });

        dialog.show();
    }
}
