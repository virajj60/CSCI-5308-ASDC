class AdminUserTest {

	public void validateCredentialsSuccessTest() {
		String admin_id = "admin";
		String admin_pass = "admin123";
		AdminUser adminTest = new AdminUser();
		if (adminTest.validateCredentials(admin_id, admin_pass) == IUser.AuthenticationResult.LOGIN_SUCCESS) {
			System.out.println("Test validateCredentialsSuccessTest() : PASSED");
		} else {
			System.out.println("Test validateCredentialsSuccessTest() : FAILED");
		}
	}

	public void validateCredentialsFailureTest() {
		String admin_id = "admin123";
		String admin_pass = "admin123";
		AdminUser adminTest = new AdminUser();
		if (adminTest.validateCredentials(admin_id, admin_pass) == IUser.AuthenticationResult.LOGIN_FAILURE) {
			System.out.println("Test validateCredentialsSuccessTest() : PASSED");
		} else {
			System.out.println("Test validateCredentialsSuccessTest() : FAILED");
		}
	}
}