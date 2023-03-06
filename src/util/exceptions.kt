package com.progressp.util

import io.ktor.http.*

abstract class ApiException(val clientMessage: String, logMessage: String, val statusCode: HttpStatusCode) :
    Exception(logMessage)

class JwtSignatureFails(cause: String) :
    ApiException("Authentication has failed", cause, HttpStatusCode.BadRequest)
class CurrencyCodeNotFound(code: String) :
    ApiException("Currency code not found", "Currency code: $code not found", HttpStatusCode.NotFound)
class InternalServerError(message: String) :
    ApiException("Internal server error", message, HttpStatusCode.InternalServerError)

class MethodNotAllowedException :
    ApiException("Method not allowed", "Method not allowed", HttpStatusCode.MethodNotAllowed)

class PreferenceDoesNotExist(name: String, userId: String) :
    ApiException("Preference not found", "Preference $name does not exist for user $userId", HttpStatusCode.NotFound)

class PreferenceNotFound(id: String) :
    ApiException("Preference not found", "Preference $id not found", HttpStatusCode.NotFound)
class StudentNotFound(id: String) :
    ApiException("Student not found", "Student $id not found", HttpStatusCode.NotFound)
class StudentGenderNotFound(userId: String, gender: Int) :
    ApiException("Student is invalid", "User $userId submitted invalid gender $gender for student", HttpStatusCode.BadRequest)
class StudentHeightIsInvalid(userId: String, height: Double) :
    ApiException("Student is invalid", "User $userId submitted invalid height $height for student", HttpStatusCode.BadRequest)
class StudentAvatarIsInvalid(userId: String, avatarId: Int) :
    ApiException("Student is invalid", "User $userId submitted invalid avatar id $avatarId for student", HttpStatusCode.BadRequest)
class StudentMeetingNotFound(id: String) :
    ApiException("Meeting not found", "Meeting $id not found", HttpStatusCode.NotFound)
class StudentNotYours(userId: String, studentId: String) :
    ApiException("Student not found", "User $userId tried to update student $studentId", HttpStatusCode.BadRequest)
class StudentSessionNotFound(id: String) :
    ApiException("Student session not found", "Student session $id not found", HttpStatusCode.NotFound)
class StudentSessionTotalInvalid(value: Int) :
    ApiException("Total value si invalid", "Value: $value is invalid", HttpStatusCode.BadRequest)
class StudentSessionStatusInvalid(userId: String, status: Int) :
    ApiException("Session status si invalid", "User $userId tried to update a session with status $status", HttpStatusCode.BadRequest)
class UserEmailExists(email: String) :
    ApiException("E-Mail already exists", "Email already exists: $email", HttpStatusCode.BadRequest)

class UserEmailInvalid(email: String) :
    ApiException("E-Mail is invalid", "Email $email is invalid", HttpStatusCode.BadRequest)

class UsernameExists(user: String) :
    ApiException("Username already exists", "Username already exists: $user", HttpStatusCode.BadRequest)

class UserIncorrectPassword :
    ApiException("Username or password incorrect", "User sent incorrect password", HttpStatusCode.BadRequest)

class UserNotFound(id: String) :
    ApiException("User not found", "User not found: $id", HttpStatusCode.NotFound)

class UserNotAdmin(userId: String) :
    ApiException("Authentication has failed", "User $userId is not admin", HttpStatusCode.BadRequest)

class UserNotAuthenticated :
    ApiException("Authentication has failed", "User is not authenticated", HttpStatusCode.BadRequest)

class UserEmailNotVerified(userId: String) :
    ApiException("E-mail is not validated", "E-Mail not validated for user $userId", HttpStatusCode.BadRequest)