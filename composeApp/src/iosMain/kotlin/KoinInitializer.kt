import Data.Di.dataModule
import Domain.Di.domainModule
import Presentation.Di.presentationModule
import org.koin.core.context.startKoin

actual class KoinInitializer {
    actual fun init() {
        startKoin {
            modules(dataModule, domainModule,presentationModule)
        }
    }
}