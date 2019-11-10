
class DatabaseAccess()
class TaxDeductionLibrary(databaseAccess: DatabaseAccess)
class TaxCalculator(taxBase: Double, taxDeductionLibrary: TaxDeductionLibrary)

trait TaxModule {

  import com.softwaremill.macwire._

  lazy val theDatabaseAccess          = wire[DatabaseAccess]
  lazy val theTaxDeductionLibrary     = wire[TaxDeductionLibrary]
  def taxCalculator(taxBase: Double)  = wire[TaxCalculator]
//   or: lazy val taxCalculator = (taxBase: Double) => wire[TaxCalculator]
}
