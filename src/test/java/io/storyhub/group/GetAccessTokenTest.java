package io.storyhub.group;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author chanwook
 */
public class GetAccessTokenTest {
    @Test
    public void get() throws Exception {
        FacebookOAuthAPI t = new FacebookOAuthAPI();

        final String accessToken = t.getAccessToken("1073538172678201", "203a15c552040c1e3effadb25a521c78", "code");
        assertThat(accessToken).isNotNull();
    }
}
