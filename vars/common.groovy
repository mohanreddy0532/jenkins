//def sonarQube() {
//  sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://3.239.211.53:9000 -Dsonar.login=admin -Dsonar.password=admin123'
//  //sh 'sonar-quality-gate.sh admin admin123 172.31.15.251 ${COMPONENT}'
//    println 'SonarQube Testing'
//}
def sonarQube() {
    sh 'sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://3.239.211.53:9000 -Dsonar.login=admin -Dsonar.password=admin123'
    sh 'sonar-quality-gate.sh admin admin123 172.31.15.251 ${COMPONENT}'
  //println 'SonarQube Testing'
}