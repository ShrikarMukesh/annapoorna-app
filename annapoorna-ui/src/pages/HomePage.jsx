import TopRestaurant from '../components/commons/TopRestaurant.jsx';
import WhatsOnYourMind from "../components/commons/WhatsOnYourMind.jsx";
import AllRestaurants from "../components/commons/AllRestaurants.jsx";
import Footer from "../components/commons/Footer.jsx";
const HomePage = () => {
    return(
        <>
            <WhatsOnYourMind/>
            <TopRestaurant/>
            <AllRestaurants />
            <Footer/>
        </>
    )
 }

 export default HomePage;