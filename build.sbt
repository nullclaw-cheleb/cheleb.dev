import org.scalajs.linker.interface.ModuleSplitStyle

lazy val root = project
  .in(file("."))
  .enablePlugins(ScalaJSPlugin)
  .settings(
    name := "cheleb.dev",
    scalaVersion := "3.8.4",
    scalacOptions ++= Seq("-encoding", "utf-8", "-deprecation", "-feature"),

    scalaJSUseMainModuleInitializer := true,
    scalaJSLinkerConfig ~= {
      _.withModuleKind(ModuleKind.ESModule)
        .withModuleSplitStyle(ModuleSplitStyle.SmallModulesFor(List("example")))
    },

//    libraryDependencies += "org.scala-js" %% "scalajs-dom" % "2.8.1", // sbt 2.x
     libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.1", // sbt 1.x
     libraryDependencies += "dev.cheleb" %%% "threesjs" % "0.1.0",
  )
