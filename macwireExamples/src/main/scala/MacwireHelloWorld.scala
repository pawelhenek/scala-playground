
class DatabaseAccess()
class SecurityFilter()
class UserFinder(databaseAccess: DatabaseAccess, securityFilter: SecurityFilter)
class UserStatusReader(userFinder: UserFinder)

trait MacwireHelloWorld {
  import com.softwaremill.macwire._

  lazy val theDatabaseAccess   = wire[DatabaseAccess]
  lazy val theSecurityFilter   = wire[SecurityFilter]
  lazy val theUserFinder       = wire[UserFinder]
  lazy val theUserStatusReader = wire[UserStatusReader]
}
