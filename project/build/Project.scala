import sbt._

class Razxml(info: ProjectInfo) extends DefaultProject(info)
{
  override def mainScalaSourcePath = "src"
  override def testScalaSourcePath = "test_src"
}

