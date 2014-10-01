package demo;

import dagger.Component;
import javax.inject.Inject;

public class JavaONE {

  @Component
  interface Server {
    MailService service();
  }

  static class MailService {
    @Inject public MailService() {

    }
  }

  public static void main(String ... args) {

  }
}
