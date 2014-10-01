package demo;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import javax.inject.Inject;

public class JavaONE {

  @Component(modules = MessageModule.class)
  interface Server {
    MailService mail();
  }

  static class MailService {
    private final Supplier<String> message;
    @Inject public MailService(Supplier<String> message) {
      this.message = message;
    }

    void send() {
      System.out.println("Mail sent: " + message);
    }
  }

  @Module static class MessageModule {
    @Provides Supplier<String> message() {
      return Suppliers.ofInstance("Foo");
    }
  }

  public static void main(String ... args) {
    Server server = Dagger_JavaONE$Server.create();
    server.mail();
  }
}
