ModsDotGroovy.make {
    def modid = this.buildProperties["mod_id"]

    modLoader = "javafml"
    loaderVersion = "[${(this.buildProperties["min_forge_version"] as String).split("\\.")[0]},)"

    license = "MIT"
    issueTrackerUrl = ""

    mod {
        modId = modid
        displayName = this.buildProperties["mod_name"]
        version = this.version
        group = this.group
        authors = [this.buildProperties["mod_author"] as String]

        displayUrl = "example.com"
//        sourcesUrl = "example.com"
        logoFile = "logo.png"
        description = ""

        onFabric {
            entrypoints {
                client = "dhyces.waxedicons.FabricWaxedIconsClient"
            }
        }

        onQuilt {
            entrypoints {
                client = "dhyces.waxedicons.QuiltWaxedIconsClient"
            }
            intermediateMappings = "net.fabricmc:intermediary"
        }

        dependencies {
            def mcVersionRange = "[1.20,1.20.2)"
            onForge {
                minecraft = mcVersionRange
                forge = "[46,)"
            }

            onFabric {
                minecraft = mcVersionRange
                fabricloader = ">=${this.fabricLoaderVersion}"
            }

            onQuilt {
                minecraft = mcVersionRange
                quilt_loader = ">=${this.quiltLoaderVersion}"
                quilted_fabric_api = ">=${this.buildProperties["quilted_fabric_version"]}"
                quilt_base = ">=${this.buildProperties["qsl_version"]}"
            }
        }
    }

    onFabricAndQuilt {
        environment = "*"
        mixin = [
                modid + ".mixins.json"
        ]
    }
}