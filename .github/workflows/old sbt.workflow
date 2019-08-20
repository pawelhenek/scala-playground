workflow "on push, build and test" {
  on = "push"
  resolves = ["build-and-test"]
}

action "build-and-test" {
  uses = "agemooij/github-actions-sbt@master"
  args = "test"
  secrets = ["BINTRAY_USERNAME", "BINTRAY_PASSWORD"]
  env = {
    SBT_OPTS = "-Xms512M -Xmx2048M -Xss2M -XX:MaxMetaspaceSize=1024M"
  }
}
