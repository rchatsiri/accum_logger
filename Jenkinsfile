/* 

Fore deployment steps with ```$sbt assembly```.

Ref: https://alvinalexander.com/scala/using-jenkins-scala-sbt-git-scalatest
*/
pipeline {
   stage('Build') {
		steps {
			echo "Compiling..."
			sh "${tool name: 'sbt', type:'org.jvnet.hudson.plugins.SbtPluginBuilder$SbtInstallation'}/bin/sbt assembly"
		}
	}
}