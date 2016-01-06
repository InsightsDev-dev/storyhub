package io.storyhub.group;

import io.storyhub.security.UserSession;
import org.junit.Test;
import org.springframework.mock.web.MockHttpSession;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author chanwook
 */
public class FacebookTemplateTest {

    public static final String ACCESS_TOKEN = "CAAPQYJVvcDkBAOEashYMpXmv2sMRpWzZBGYnTeoZAql0GW9qBzttb0n47xldD8vfyNAo1QumWAN7Q3j5SInZCvKqxxHSglz1BOm4YOZAFqhilR6cXbXOYvplvmfJB0NSZCE00yD1jDeBrRJRYmBK8dwWbAZBzqNCRtlMMwo2uUebZCaxELlCt593Ofnx4LDCepzqolxGISSVDl9Hz6r90rp";
    public static final String USER_ID = "1019704548086386";
    private final String TEST_GROUP_ID = "206475916202991";

    @Test
    public void groupList() throws Exception {
        final FacebookTemplate t = new FacebookTemplate(createUserSession());
        final List<FacebookGroup> groupList = t.groupList();

        assertThat(groupList).isNotNull();

        // assert for test group
        final FacebookGroup testGroup = getTestGroup(groupList);
        assertThat(testGroup).isNotNull();
        assertThat(testGroup.getName()).isEqualTo("ISUG");

        //TODO assertion
    }

    @Test
    public void feedOfGroup() throws Exception {

        final FacebookTemplate t = new FacebookTemplate(createUserSession());
        final List<Post> postList = t.feedOfGroup(TEST_GROUP_ID);

        assertThat(postList).isNotNull();
        System.out.println(postList.size());

    }

    private UserSession createUserSession() {
        final UserSession userSession = new UserSession(new MockHttpSession());
        userSession.createUserSession(ACCESS_TOKEN, USER_ID);
        return userSession;
    }

    private FacebookGroup getTestGroup(List<FacebookGroup> groupList) {
        for (FacebookGroup each : groupList) {
            System.out.println(each.getId());
            if (TEST_GROUP_ID.equals(each.getId())) return each;
        }
        return null;
    }
}
