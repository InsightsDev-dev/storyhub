package io.storyhub.post;

import io.storyhub.facebook.FacebookGraphAPI;
import io.storyhub.facebook.model.Group;
import io.storyhub.facebook.model.Post;
import io.storyhub.security.UserSession;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author chanwook
 */
public class FacebookTemplateTest {

    public static final String ACCESS_TOKEN = "CAAPQYJVvcDkBAPa0XMFsNZBlQvg9EjqZAtEVe2P4c6ELh91b6b8GRW0B3oDG4gYzWG7XWggWRwllZBvZCllc3jtu4zlZB4iWsP4gwvkD8oUdqxs1r5ENVTLLwViJIr79ZCWZBNZC0hCLXbOUnjuu09FSud1VWnOoJAnltO0ZCgPj53bZC8yeBmrZAx8AnEu72zPYYWiAvwRTzdAbQZDZD";
    public static final String USER_ID = "122583464785986";

    private final String TEST_GROUP_ID = "206475916202991";

    @Test
    public void groupList() throws Exception {
        final FacebookGraphAPI t = new FacebookGraphAPI(createUserSession());
        final List<Group> groupList = t.groupList();

        assertThat(groupList).isNotNull();

        // assert for test group
        final Group testGroup = getTestGroup(groupList);
        assertThat(testGroup).isNotNull();
        assertThat(testGroup.getName()).isEqualTo("ISUG");

        //TODO assertion
    }

    private UserSession createUserSession() {
        return FacebookTestUtils.createUserSession(ACCESS_TOKEN, USER_ID);
    }

    @Test
    public void feedOfGroup() throws Exception {

        final FacebookGraphAPI t = new FacebookGraphAPI(createUserSession());
        final List<Post> postList = t.feedOfGroup(TEST_GROUP_ID);

        assertThat(postList).isNotNull();
        System.out.println(postList.size());

    }

    private Group getTestGroup(List<Group> groupList) {
        for (Group each : groupList) {
            System.out.println(each.getId());
            if (TEST_GROUP_ID.equals(each.getId())) return each;
        }
        return null;
    }
}
