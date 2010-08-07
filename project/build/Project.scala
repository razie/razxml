import sbt._

class Razxml(info: ProjectInfo) extends DefaultProject(info)
{
  lazy val hi = task { println("Hello World"); None }

  override def outputDirectoryName = "bin"

  override def mainScalaSourcePath = "src"
//  override def mainResourcesPath = "resources"

  override def testScalaSourcePath = "test_src"
//  override def testResourcesPath = "test-resources"
}

