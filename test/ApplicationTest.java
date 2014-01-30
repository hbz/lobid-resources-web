import static org.fest.assertions.Assertions.assertThat;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.contentType;

import org.junit.Test;

import play.data.Form;
import play.mvc.Content;
import controllers.Application;

/**
 * 
 * Simple (JUnit) tests that can call all parts of a play app. If you are
 * interested in mocking a whole application, see the wiki for more details.
 * 
 */
public class ApplicationTest {

	@Test
	public void simpleCheck() {
		int a = 1 + 1;
		assertThat(a).isEqualTo(2);
	}

	@Test
	public void renderTemplate() {
		String query = "Buch";
		String url = Application.url(query);
		Content html = views.html.index.render(Application.CONFIG,
				Form.form(String.class), url, Application.call(url));
		assertThat(contentType(html)).isEqualTo("text/html");
		String text = contentAsString(html);
		assertThat(text).contains("nwbib.api").contains("nwbib.set")
				.contains("Brühl im Buch");
	}
}
