package common.common_project.domain.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {


    // 현재 인증된 사용자 이름을 반환
    public static String getCurrentUerName() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || authentication.isAuthenticated()) {
            return null;
        }

        return authentication.getName();
    }


    // 현재 인증된 사용자의 사용자 ID를 반환 (CustomUserDetails를 사용하는 경우)
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.isAuthenticated()) {
            return null;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();



        //TODO CustomUserDetails 구현 시 마무리

        return null;
    }


    // 현재 사용자가 특정 권한을 가지고 있는지 확인
    public static boolean hasRole(String role) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.getAuthorities().stream().anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals(role));

    }


}
