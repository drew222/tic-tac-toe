package com.example.tictac;
import com.example.tictac.health.TemplateHealthCheck;
import dagger.Component;
import javax.inject.Singleton;
/**
 * Created by drewzoellner on 2/23/16.
 */

@Singleton
@Component(modules = TicTacApplicationModule.class)
interface TicTacApplicationComponent {
    TicTacGameResource getTicTacGameResource();

    TicTacResource getTicTacResource();

    TemplateHealthCheck getTemplateHealthCheck();
}
