
class DatabaseAccess()
class SecurityFilter()
class UserFinder(databaseAccess: DatabaseAccess, securityFilter: SecurityFilter)
class UserStatusReader(userFinder: UserFinder)

trait MacwireDependencyInjection {

  import com.softwaremill.macwire._

  lazy val pointSwitcher = wire[PointSwitcher]
  lazy val trainCarCoupler = wire[TrainCarCoupler]
  lazy val trainShunter = wire[TrainShunter]

  lazy val craneController = wire[CraneController]
  lazy val trainLoader = wire[TrainLoader]
  lazy val trainDispatch = wire[TrainDispatch]

  lazy val trainStation = wire[TrainStation]

  trainStation.prepareAndDispatchNextTrain()

}
