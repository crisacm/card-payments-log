package com.github.crisacm.cardpaymentslog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.crisacm.cardpaymentslog.nav.AppNavigation
import com.github.crisacm.cardpaymentslog.ui.theme.CardPaymentsLogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardPaymentsLogTheme {
                AppNavigation()
            }
        }
    }
}
