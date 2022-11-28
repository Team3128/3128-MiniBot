/*
 *	  Copyright (C) 2022  John H. Gaby
 *
 *    This program is free software: you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation, version 3 of the License.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *    
 *    Contact: robotics@gabysoft.com
 */

//  package robot;

// import robotCore.Device;
// import robotCore.DigitalOutput;
// import robotCore.Logger;
// import robotCore.PiCamera;
// import robotCore.PiCamera.PiCameraRegion;
// import robotCore.PiCamera.PiCameraRegions;

// public class Camera {
//     private final static String m_ip = "172.24.1.1";
//     private static final int k_pin = Device.M3_2_PWM;

//     private final PiCamera m_camera = new PiCamera();
//     private final DigitalOutput m_light = new DigitalOutput(k_pin);

//     public class CameraFrame {
//         PiCameraRegions m_regions = m_camera.getRegions();

//         /*
//          *
//          * Returns true if there is at least one region visible
//          */
//         public boolean isVisible() {
//             return (m_regions != null) && (m_regions.getRegionCount() >= 1);
//         }

//         /*
//          * Returns the horizontal center of the first visible region with respect to the
//          * horizontal target position set by the image viewer
//          * 
//          * NOTE: This function should ONLY be called if isVisible returns true
//          */
//         public int getTargetCenter() {
//             PiCameraRegion region = m_regions.getRegion(0);

//             // Logger.Log("Camera", 1, String.format("left=%d, right=%d", region.m_topLeft,
//             // region.m_topRight));

//             return ((region.m_bounds.m_left + region.m_bounds.m_right) / 2) - m_regions.m_targetHorzPos;
//         }
//     }

//     public Camera() {
//         m_camera.connect(m_ip, 5800);
//     }

//     public void setLight(boolean on) {
//         Logger.log("Camera", 2, String.format("SetLight: %s", on ? "on" : "off"));

//         m_light.set(on);
//     }

//     public CameraFrame getCurrentFrame() {
//         return new CameraFrame();
//     }


