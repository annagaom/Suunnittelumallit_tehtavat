package Proxy;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;
    private final Set<String> accessList;

    private AccessControlService() {
        accessList = new HashSet<>();
    }

    public static AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }

    public void allowAccess(String documentId, String username) {
        accessList.add(username + ":" + documentId);
    }

    public boolean isAllowed(String documentId, String username) {
        return accessList.contains(username + ":" + documentId);
    }
}
