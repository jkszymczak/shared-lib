def scan(imageName) {
     sh 'docker run --name trivy_container -v /var/run/docker.sock:/var/run/docker.sock -v $HOME/Library/Caches:/root/.cache/ aquasec/trivy:0.53.0 image ' + imageName +' -f template --template "@contrib/html.tpl" -o /report.html'
    sh 'docker cp trivy_container:/report.html .'
    sh 'docker rm trivy_container'   
}
