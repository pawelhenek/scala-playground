import org.specs2.Specification

class MacwireDependencyInjectionForTests extends Specification with MacwireDependencyInjection {

//  override lazy val theDatabaseAccess = mockDatabaseAccess
//  override lazy val theSecurityFilter = mockSecurityFilter

  val trainMessage = trainStation.prepareAndDispatchNextTrain()

  def is = s2"""

  This is a specification for the 'Hello world' string

  The 'Hello world' string should
    contain 11 characters                             $e1
    start with 'Hello'                                $e2
    end with 'world'                                  $e3
    train message starts with 'Hello'                 $e4
                                                      """
  def e1 = "Hello world" must haveSize(11)
  def e2 = "Hello world" must startWith("Hello")

  def e3 = "Hello world" must endWith("world")

  def e4 = trainMessage must startingWith("Hello")

}
