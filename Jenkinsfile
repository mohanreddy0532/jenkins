pipeline {
  agent { label 'WORKSTATION' }

  stages {
    stage('sh commands') {
      steps {
        sh 'uptime;uname -a;'
      }
    }
  }

}