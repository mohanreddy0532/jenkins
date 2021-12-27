// pipeline {
//   agent { label 'WORKSTATION' }
//
//   stages {
//     stage('sh commands') {
//       steps {
//         sh 'uptime;uname -a;'
//       }
//     }
//   }
//
// }
//===============================================
//node {
//  stage('One') {
//    sh 'echo Hello'
//  }
//  stage('Two') {
//    sh 'echo Hello'
//  }
//}
//

// ========Agent example==========
//
//pipeline {
//  agent any
//  agent none
//  agent {
//    node { 'workstation'}
//  }
//  agent {
//    label { 'ANSIBLE && CENTOS' }
//  }
//
//  stages {
//    stage('sample') {
//      agent { label 'UBUNTU' }
//      steps {
//        sh 'echo heloo'
//      }
//    }
//  }
//
//}

//===========Options example=====================

//pipeline {
//  agent any
//  options { disableConcurrentBuilds() }
//  stages {
//    stage('ONE') {
//      steps {
//        sh 'sleep 10'
//      }
//    }
//  }
//}

//=======Environment example==============
// pipeline {
//   agent any
//   environment {
//     URL1 = "google.com"
//     SSH = credentials("CENTOS")
//     SSH1 = credentials("common/ssh")
//   }
//   stages {
//     stage('ONE') {
//       steps {
//         sh 'echo ${URL1}'
//         sh 'env'
//         echo SSH
//         sh 'echo ${SSH1} | base64'
//       }
//     }
//   }
// }

//=======Parameters Example==============
// pipeline {
//  agent any
//  parameters {
//    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
//
//    text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
//
//    booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
//
//    choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
//
//    password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
//  }
//  stages {
//    stage('Example') {
//      steps {
//        echo "Hello ${params.PERSON}"
//
//        echo "Biography: ${params.BIOGRAPHY}"
//
//        echo "Toggle: ${params.TOGGLE}"
//
//        echo "Choice: ${params.CHOICE}"
//
//        echo "Password: ${params.PASSWORD}"
//      }
//    }
//  }
// }
//=======Triggers Example==============
pipeline {
 agent {
   label 'WORKSTATION'
 }
 tools {
   maven 'maven-3.8.5'
 }
 stages {
   stage('Maven') {
     steps {
       sh 'mvn --version'
     }
   }
 }
}


//=======Tools Example==============

