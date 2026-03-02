# Bug Report: User Authentication Failure (500 Internal Server Error)

**Reported by:** Sahan Manusha

**Priority:** High

**Status:** Open

**Component:** User Auth Service/Frontend

## Summary

Automated regression tests identified a critical failure during the login flow. Users are unable to reach the "Secure Area" despite providing valid credentials. The system returns a `500 Internal Server Error` instead of a redirect.

## Environment

- **URL:** `https://the-internet.herokuapp.com/login`
- **Browser:** v148.0
- **Test Script:** `App.java` (Selenium WebDriver)
- **Execution Environment:** Local Maven Build/Windows 10

## Steps to Reproduce

1. Launch the **Login Automator** script / or navigate to the login page manually.
2. Enter valid username: `tomsmith`
3. Enter valid password: `SuperSecretPassword!`
4. Click the Login button.

## Expected Result

The system should redirect the user to the `/secure` dashboard and display the flash message: *"You logged into a secure area!"*

## Actual Result

The page hangs and eventually returns a `500 Internal Server Error`. The Selenium script failed at the assertion: `actualText.contains("You logged into a secure area!")`.

## Root Cause Analysis

- **API Validation:** Ran the Postman Collection against the `/login` endpoint. The API returned a `500` status code with the message: `Database Connection Timeout`.

- **Database Health Check:** Executed the Java/JDBC Data Checker. Confirmed that the `users` table is accessible, but latency on the session table is exceeding 2000ms.

- **Log Snippet:** `[ERROR] 2024-05-20 14:10:05 - ConnectionPool: Max limit reached for user 'auth_service'.`

### Evidence / Attachments

- `screenshot_failure.png`
- `postman_response_log.json`