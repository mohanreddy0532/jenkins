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
      ls -ltr
    '''
  }
  // Java
  // Python
  // Golang
}