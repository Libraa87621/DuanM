package Login_SingIn;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.dnmu.R;
import com.google.android.material.navigation.NavigationView;

import User.AccountActivity;

public class UserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        // Find the DrawerLayout
        drawer = findViewById(R.id.drawer_layout);

        // Set up the navigation view
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Find the ImageButton for the menu
        ImageButton iconMenu = findViewById(R.id.iconMenu);
        iconMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        // Handle click on Trang chủ
                        handleHome();
                        return true;
                    case R.id.menu_rent_car:
                        // Handle click on Thuê xe
                        handleRentCar();
                        return true;
                    case R.id.menu_flight_tickets:
                        // Handle click on Vé máy bay
                        handleFlightTickets();
                        return true;
                    case R.id.menu_contact:
                        // Handle click on Liên hệ
                        handleContact();
                        return true;
                    case R.id.menu_about:
                        // Handle click on Giới thiệu
                        handleAbout();
                        return true;
                    case R.id.menu_logout:
                        // Handle click on Đăng xuất
                        handleLogout();
                        return true;
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    private void handleHome() {
        // Code to handle Home
    }

    private void handleRentCar() {
        // Code to handle Rent Car
    }

    private void handleFlightTickets() {
        // Code to handle Flight Tickets
    }

    private void handleContact() {
        // Code to handle Contact
    }

    private void handleAbout() {
        // Code to handle About
    }

    private void handleLogout() {
        // Code to handle Logout
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_contact) {
            // Handle click on Liên hệ
            Intent intent = new Intent(this, AccountActivity.class);
            startActivity(intent);
            return true;
        }
        // Handle other menu items

        // Close the drawer
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
