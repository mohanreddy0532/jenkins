import org.jenkinsci.plugins.pipeline.modeldefinition.Utils


def sonarQube() {
//  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.15.251:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//  sh 'sonar-quality-gate.sh admin admin123 172.31.15.251 ${COMPONENT}'
  println 'SonarQube Testing'
}

def publishArtifacts() {
//  if(env.GIT_BRANCH == "*tag*") {
//    println 'Ran on Tag'
//  } else {
//    Utils.markStageSkippedForConditional('Publish Artifacts')
//  }
  sh '''
    curl -f -v -u ${NEXUS_USR}:${NEXUS_PSW} --upload-file ${COMPONENT}-${gitTag}.zip http://nexus.roboshop.internal:8081/repository/${COMPONENT}/${COMPONENT}-${gitTag}.zip
  '''
}

def prepareArtifacts() {
  if(env.PROG_LANG_NAME == "nodejs" && env.PROG_LANG_VERSION == "6") {
    sh '''
      npm install 
      zip -r ${COMPONENT}-${gitTag}.zip node_modules server.js
    '''
  }

  if(env.PROG_LANG_NAME == "java" && env.PROG_LANG_VERSION == "1.8") {
    sh '''
      mvn clean package 
      mv target/${COMPONENT}-1.0.jar ${COMPONENT}.jar
      zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}.jar
    '''
  }

  if(env.PROG_LANG_NAME == "python" && env.PROG_LANG_VERSION == "3") {
    sh '''
      zip -r ${COMPONENT}-${gitTag}.zip requirements.txt *.py ${COMPONENT}.ini
    '''
  }


  if(env.PROG_LANG_NAME == "golang" && env.PROG_LANG_VERSION == "1.5") {
    sh '''
      go mod init dispatch
      go get 
      go build 
      zip -r ${COMPONENT}-${gitTag}.zip ${COMPONENT}
    '''
  }

  if(env.PROG_LANG_NAME == "angular") {
    sh '''
      cd static
      zip -r ../${COMPONENT}-${gitTag}.zip * 
    '''
  }


}