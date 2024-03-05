package es.neesis;

import es.neesis.applications.HangmanApplication;
import es.neesis.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HangmanApplication app = context.getBean(HangmanApplication.class);
        app.run();
    }
}
