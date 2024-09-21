import TopRestaurant from '../components/TopRestaurant.jsx';
import ViewAllJobs from "../components/ViewAllJobs.jsx";
import WhatsOnYourMind from "../components/WhatsOnYourMind.jsx";
import AllRestaurants from "../components/AllRestaurants.jsx";
import Footer from "../components/Footer.jsx";
const HomePage = () => {
    return(
        <>
            <WhatsOnYourMind/>
            <TopRestaurant/>
            <AllRestaurants />
            <ViewAllJobs/>
            <Footer/>
        </>
    )
 }

 export default HomePage;